import os

from cs50 import SQL
from flask import Flask, flash, redirect, render_template, request, session
from flask_session import Session
from tempfile import mkdtemp
from werkzeug.security import check_password_hash, generate_password_hash

from helpers import login_required
from datetime import datetime, timezone

# Configure application
app = Flask(__name__)

# Ensure templates are auto-reloaded
app.config["TEMPLATES_AUTO_RELOAD"] = True


# Configure session to use filesystem (instead of signed cookies)
app.config["SESSION_PERMANENT"] = False
app.config["SESSION_TYPE"] = "filesystem"
Session(app)

# Configure CS50 Library to use SQLite database
db = SQL("sqlite:///tracker.db")

# Make sure API key is set
if not os.environ.get("API_KEY"):
    raise RuntimeError("API_KEY not set")


@app.after_request
def after_request(response):
    """Ensure responses aren't cached"""
    response.headers["Cache-Control"] = "no-cache, no-store, must-revalidate"
    response.headers["Expires"] = 0
    response.headers["Pragma"] = "no-cache"
    return response

@app.route("/")
@app.route("/index")
@login_required
def index():

    user_id = session["user_id"]

    weight = db.execute("SELECT weight FROM orders WHERE user_id = ?",user_id)[0]['weight']
    height = db.execute("SELECT height FROM orders WHERE user_id = ?",user_id)[0]['height']
    age = db.execute("SELECT age FROM orders WHERE user_id = ?",user_id)[0]['age']
    calorie = db.execute("SELECT calorie FROM orders WHERE user_id = ?",user_id)[0]['calorie']

    return render_template("index.html", weight=weight, height=height, age=age, calorie=calorie)

@app.route("/update", methods=["GET", "POST"])
@login_required
def update():
    if request.method == "GET":
        return render_template("update.html")

    if request.method == "POST":
        gender = request.form.get("gender")
        age = int(request.form.get("age"))
        weight = int(request.form.get("weight"))
        height = int(request.form.get("height"))
        user_id = session["user_id"]


        if gender == "male":
            calorie = 66.5 + 13.8 * weight + 5 * height / 6.8 * age
            calorie = round(calorie, 2)
        else:
            calorie = 655.1 + 9.6 * weight + 1.9 * height / 4.7 * age
            calorie = round(calorie, 2)

        if calorie < 0:
            return render_template("apology.html")

        db.execute("UPDATE orders SET weight = ?, height = ?, age = ?, calorie = ? WHERE user_id = ?", weight, height, age, calorie, user_id)

    return redirect("/")


@app.route("/login", methods=["GET", "POST"])
def login():
    """Log user in"""

    # Forget any user_id
    session.clear()

    # User reached route via POST (as by submitting a form via POST)
    if request.method == "POST":

        # Ensure username was submitted
        if not request.form.get("username"):
            return render_template("apology.html")

        # Ensure password was submitted
        elif not request.form.get("password"):
            return render_template("apology.html")

        # Query database for username
        rows = db.execute("SELECT * FROM users WHERE username = ?", request.form.get("username"))

        # Ensure username exists and password is correct
        if len(rows) != 1 or not check_password_hash(rows[0]["hash"], request.form.get("password")):
            return render_template("apology.html")

        # Remember which user has logged in
        session["user_id"] = rows[0]["id"]

        # Redirect user to home page
        return redirect("/")

    # User reached route via GET (as by clicking a link or via redirect)
    else:
        return render_template("login.html")

@app.route("/logout")
def logout():
    """Log user out"""

    # Forget any user_id
    session.clear()

    # Redirect user to login form
    return redirect("/")

@app.route("/register", methods=["GET", "POST"])
def register():
    """Register user"""
    if request.method == "GET":
        return render_template("register.html")

    if request.method == "POST":
        if not request.form.get("username"):
            return render_template("apology.html")

        elif not request.form.get("password"):
            return render_template("apology.html")

        elif request.form.get("confirmation") != request.form.get("password"):
            return render_template("apology.html")

        username = request.form.get("username")
        password = request.form.get("password")

        p_hash = generate_password_hash(password, method = 'pbkdf2:sha256', salt_length = 8)

        if len(db.execute("SELECT username FROM users WHERE username == :username", username=username)) == 0:
            db.execute("INSERT INTO users (username, hash) VALUES (:username, :hash)", username=username, hash=p_hash)

            user_id = db.execute("SELECT id FROM users WHERE username == :username", username=username)[0]['id']
            db.execute("INSERT INTO orders (user_id, weight, height, age, calorie) VALUES (?, ?, ?, ?, ?)", \
                                     user_id, 0, 0, 0, 0)

            return redirect("/")
        else:
            return render_template("apology.html")
