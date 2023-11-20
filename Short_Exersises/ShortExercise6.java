import java.util.Scanner;

class LapTimes
{
    public static void main (String [] a)
    {
        Times();
        return;
    }

    //Outputs a message and asks user for a responce
    public static String InputString(String message)
    {
        String answer;

        Scanner scanner = new Scanner(System.in);

        System.out.print(message);
        answer = scanner.nextLine();

        return answer;
        
    }

    //Converts a string into an integer
    public static int Convert(String StrTime)
    {
        int time;
        boolean again = true;

        while(again)
        {
            for(int i = 0; i < StrTime.length(); i++)
            {
                if(StrTime.charAt(i) < '0' || StrTime.charAt(i) > '9')
                {
                    StrTime = InputString("Enter an integer");
                    break;
                }
                else if(i == StrTime.length() - 1)
                {
                    again = false;
                }
            }
        }

        time = Integer.parseInt(StrTime);
        return time;
    }

    //calculartes difference of the two numbers in the array
    public static void Difference(int [] times)
    {
        int diff;

        diff = times[0] - times[1];

        if (diff < 0) //if difference is a negative then it gets converted into a positive number
        {
            diff = diff * -1;
        }

        System.out.println("Difference " + diff + " seconds");

        return;
    }
    
    //Main part of program
    public static void Times()
    {
        String StrTime = ""; 
        int laps = 1; //amount of laps
        int sum = 0;
        int [] times = new int[2];

        System.out.println("Training Run Data");
        System.out.println("-----------------");

        while (!StrTime.equalsIgnoreCase("XXX"))
        {
            for (int i = 0; i <= 1; i++)
            {
                StrTime = InputString("What was lap time " + laps + " (in s)?  ");

                if (StrTime.equalsIgnoreCase("XXX")) //if input xxx stop program
                {
                    break;
                }
                
                times[i] = Convert(StrTime);

                if (laps != 1)
                {
                    Difference(times);
                }

                sum = sum + times[i]; //adds the lap time to the sum
                laps++; //increase ammount of laps
            }
        }

        System.out.println("You did " + (laps-1) + " laps. Your total time today was " + sum + "s");

        return;
    }   
}