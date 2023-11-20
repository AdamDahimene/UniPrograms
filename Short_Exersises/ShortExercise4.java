import java.util.Scanner; // Needed to make Scanner available

class Pollution // change the name to something appropriate
{
    public static void main (String [] a)
    {
        RiverPollution(); //Change this to a call to the method doing the work
        return;
    } // END main
    
    //checks the quality by comapring value given
    public static String Quality(int num)
    {
        if (num <= 200)
        {
            return "GOOD";
        }
        else if (num <= 400)
        {
            return "SUFFICIENT";
        }
        else
        {
            return "POOR";
        }
    }

    // Calculates the average
    public static int average(int sum)
    {
        double value;
        int answer;
        final double SAMPLES = 5.0; // value does not change as samples given
    
        value = Math.round(sum / SAMPLES);
        answer = (int)value; //convert from double to int
    
        return answer;
    }

    // compares two values and returns the bigger one
    public static int compare(int greatest, int sample)
    {
        if (sample > greatest)
        {
            return sample;
        }
        else
        {
            return greatest;
        }
    }

    // Prints message 5 times using for loop
    public static void RiverPollution()
    {
        int greatest = 0;
        int sample;
        int sum = 0;
        
        for (int i = 1; i <= 5; i++)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Sample " + i + ": What was the water quality measurement in CFU/ml?   ");

            sample = Integer.parseInt(scanner.nextLine());
            while (sample < 0)
            {
                System.out.print("Sample " + i + ": Please write a suitable water quality measurement in CFU/ml?   ");
                sample = Integer.parseInt(scanner.nextLine());
            }
            greatest = compare(greatest , sample);

            sum = sum + sample;

        }
        //prints messages
        System.out.println("The worst water quality today was " + greatest + " CFU/ml.");
        System.out.println("The average water quality today was " + average(sum) + " CFU/ml.");
        System.out.println("The water quality is " + Quality(greatest) + " today.");

        return;
    }

} // END class name