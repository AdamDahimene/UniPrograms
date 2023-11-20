import java.util.Scanner;
import java.util.Random;

class Forest_Game 
{
    public static void main (String [] a)
    {
        final int Health_Points = 20; //Constant variable as it does not change in main
        String name;
        int score;

        name = Beginning(); //Gets name of user

        score = Middle(Health_Points, name); //Main part

        End(score); //Prints score

        return;
    }
    

    //Gets message and prints message then asks user input and returns it
    public static String InputString(String message)
    {
        String answer;

        Scanner scanner = new Scanner(System.in);

        System.out.print(message);
        answer = scanner.nextLine();

        return answer;
    }


    //Start of code and prints what the program does and asks for the name of adventurer
    public static String Beginning()
    {
        String name;

        System.out.println("Hello adventurer! Welcome to The Forest.");
        System.out.println("You will be able to wander through a forest where you can heal sick animals and collect plants that improve your healing skills.");
        System.out.println("But be careful! Healing sick animals will lose you two health points.");
        System.out.println();

        name = InputString("What is your adventurer name going to be?  ");

        System.out.println(name + ", you are now in The Forest. You start with 20 health points.");
        System.out.println();

        return name;
        
    }

    
    // returns what animal is chosen from an array of animals and uses the number from a for loop
    public static String Animals(int num , String [] animals)
    {
        String animal;

        animal = animals[num];

        return animal;

    }


    //Calculates how much damage each animal gets to give variety
    public static int Hurt_Animal(String animal, String name)
    {
        int damage = 0;
        Random rand = new Random();
        while (damage == 0)
        {
            damage = rand.nextInt(11); //picks a number from 1 to 10
        }

        System.out.println(name + " just found a " + animal + " injured with " + damage + " damage points."); //prints what animal and how damaged

        return damage;
    }


    //Asks user if it should heal the animal
    public static String Decision(String animal)
    {
        String decision;
        decision = InputString("Would you like to heal the " + animal + "?  ");


        while (!decision.equalsIgnoreCase("Yes") & !decision.equalsIgnoreCase("No")) //checks if input is yes or no and if not then asks again until right input
        {
            decision = InputString("Please choose either Yes or No.  ");
        }

        return decision;
    }


    //If healing then rolls a dice and sees if successful
    public static int Heal(int damage, int Health_Points, String animal)
    {
        Random rand = new Random();
        
        final int roll = rand.nextInt(11); //number from 0 to 10
        
        System.out.println();
        System.out.println("You have rolled... " + roll);
        System.out.println();
        
        
        if (roll >= damage)
        {
            Health_Points = Health_Points + 2; //add two points
            System.out.println("Well Done! You have successfully healed the " + animal + ".");
            System.out.println("You now have " + Health_Points + " health points.");
            System.out.println();

            return Health_Points;
        }
        else
        {
            Health_Points = Unsuccessful(damage, Health_Points, animal);

            return Health_Points;
        }
        
    }


    //if no heal then lose 1 point
    public static int NoHeal(int damage, int Health_Points, String animal)
    {
        Health_Points = Health_Points - 1;

        System.out.println();
        System.out.println("Poor " + animal + ", karma just hit you. You hit your head on a rock.");
        System.out.println("You lost 1 health point.");
        System.out.println("You now have " + Health_Points + " health points.");
        System.out.println();

        return Health_Points;
    }


    //asks if heal the animal again
    public static int Unsuccessful(int damage, int Health_Points, String animal)
    {
        String decision;

        Health_Points = Health_Points - 3; //lose three points

        System.out.println("Noooo! You were unsuccessful. Three points have been deducted.");
        System.out.println("You now have " + Health_Points + " health points.");
        System.out.println();


        decision = Decision(animal); //asks if should heal again

        if (decision.equalsIgnoreCase("Yes"))
        {
            Health_Points = Heal(damage, Health_Points, animal); //tries again to heal
        }
        
        System.out.println();
        return Health_Points;
    }

    //Main part of program
    public static int Middle(int Health_Points, String name)
    {
        String animal;
        String decision;
        int damage;
        int score = 0; // start of score
        final String [] animals = {"Wolf", "Rabbit", "Deer", "Racoon", "Bear", "Monkey"}; // array of animal options

        
        while (Health_Points > 0) //stops if health is 0
        {
            for (int i = 0; i < 6; i++) //goes through different animals
            {
                animal = Animals(i , animals); //select animal
                damage = Hurt_Animal(animal, name); //amount of damage
        
                decision = Decision(animal); //the decition

                if (decision.equalsIgnoreCase("Yes"))
                {
                    Health_Points = Heal(damage, Health_Points, animal);
                    score++; //if choose heal then add one point to score

                }
                else
                {
                    Health_Points = NoHeal(damage, Health_Points, animal);
                }
                if (Health_Points <= 0) //if reaches 0 then break for and while loop
                {
                    break;
                }
            }
        }
        return score;
    }

    //prints the score of the player
    public static void End(int score)
    {
        System.out.println();
        System.out.println("Game over :(");
        System.out.println("You have unfortunatly lost all health points.");
        System.out.println();
        System.out.println("Your score is " + score + ".");

        return;
    }
}