import java.util.Scanner;

//create class of records
class Rating
{
    String name;
    int access;
    int toilets;
    int parking;
    int total;
    String rating;
}

class DisabilityRating
{
    public static void main(String [] args)
    {
        restaurant();

        return;
    }

    //Gets message and prints message then asks user input and returns it
    public static String InputString(String message)
    {
        String answer;

        Scanner scanner = new Scanner(System.in);

        System.out.print(message + "  ");
        answer = scanner.nextLine();

        //check if input is empty
        while(answer.isEmpty())
        {
            System.out.print("Cannot leave empty  ");
            answer = scanner.nextLine();
        }

        return answer;
    }

    //Converts a string into an integer
    public static int InputNum(String message)
    {
        String input = InputString(message);

        boolean again = true;

        while(again)
        {
            for(int i = 0; i < input.length(); i++)
            {
                if(input.charAt(i) < '0' || input.charAt(i) > '9')
                {
                    input = InputString("Enter an integer");
                    break;
                }
                else if(i == input.length() - 1)
                {
                    again = false;
                }
            }
        }

        int answer = Integer.parseInt(input);
        return answer;
    }

    //create initial ratings of record
    public static Rating createRating(String name)
    {
        Rating rating = new Rating();

        rating.name = name;
        rating.access = 0;
        rating.toilets = 0;
        rating.parking = 0;
        rating.total = 0;
        rating.rating = "UNRATED";

        return rating;        
    }

    //set the ratings that the user has given
    public static Rating setRating(Rating rating, int access, int toilets, int parking)
    {
        rating.access = access;
        rating.toilets = toilets;
        rating.parking = parking;
        rating.total = access + toilets + parking;

        return rating;
    }

    //The GET methods
    public static int getAccess(Rating rating)
    {
        return rating.access;
    }

    public static int getToilets(Rating rating)
    {
        return rating.toilets;
    }

    public static int getParking(Rating rating)
    {
        return rating.parking;
    }

    public static int getTotal(Rating rating)
    {
        return rating.total;
    }

    public static String getName(Rating rating)
    {
        return rating.name;
    }

    public static String getRatings(Rating rating)
    {
        return rating.rating;
    }

    //check if input is from 1 to 3
    public static int check(int num)
    {
        while (num < 1 || num > 3)//if not 1 to 3 ask again
        {
            num = InputNum("Enter a score of the range 1-3");
        }

        return num;
    }

    //calculate final rating score and prints the score
    public static Rating finalRating(Rating rating)
    {

        if (getTotal(rating) == 9)
        {
            rating.rating = "OUTSTANDING";
        }
        else if (getTotal(rating) > 5)
        {
            rating.rating = "GOOD";
        }
        else
        {
            rating.rating = "POOR";
        }
        System.out.println(getName(rating) + " has a disablility rating of " + getRatings(rating));
        System.out.println();

        return rating;
    }

    //Checks if input is Y/N for boolean return
    public static Boolean Decision(String message)
    {
        String answer = InputString(message);

        while(!(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N")))
        {
            answer = InputString("Please choose Y/N");
        }

        if(answer.equalsIgnoreCase("Y"))
        {
            return true;
        }

        return false;
    }

    //main method ask for rating and calls methods
    public static void restaurant()
    {
        Boolean another = true;
        String name;
        int access;
        int toilets;
        int parking;
        Rating rating;

        while(another)
        {
            name = InputString("What is the name of the resturant");

            rating = createRating(name);

            access = InputNum("What is the score for step-free access?");
            access = check(access);

            toilets = InputNum("What is the score for disabled toilets?");
            toilets = check(toilets);

            parking = InputNum("What is the score for disabled parking?");
            parking = check(parking);
            System.out.println();

            rating = setRating(rating, access, toilets, parking);

            finalRating(rating);

            another = Decision("Another  (y/n)?");
        } 
    }
}