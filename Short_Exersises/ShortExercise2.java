import java.util.Scanner;
 // Needed to make Scanner available

class World_Cup_Stats // change the name to something appropriate
{
    public static void main (String [] a)
    {
        User_Inputs(); //call to the method doing the work
        return;
    } // END main
    
   // Add all methods the program uses here
    public static int Goals_Scored_per_Minute(int goals , int matches)
    {
        int answer; //answer of calculation

        answer = goals / matches;

        return answer;
    }

    // Finds minutes oer goal and takes goal and matches as perameters
    public static double Minutes_per_Goal(int goal , int matches)
    {
        final int MATCH_DURATION = 90; //minutes for a match
        double total_minutes; //to find total minutes of play time
        double answer;

        total_minutes = MATCH_DURATION * matches;
    
        answer = total_minutes / goal;

        answer = Math.round(answer * 10.0) / 10.0; // rounding to 1 decimal place
    
        return answer;
    }

    // Asks for all user inputs and the does calculations to give statistics
    public static void User_Inputs()
    {
        int matches;
        int goals;
        int GSM; //Goals scored per minute 
        double MG; //minutes per goal
    

        Scanner scanner = new Scanner(System.in);

        //Asks for mathces been played
        System.out.println("How many matches have been played so far?");
        matches = Integer.parseInt(scanner.nextLine());

        //Asks for goals been scored
        System.out.println("How many goals have been scored so far?");
        goals = Integer.parseInt(scanner.nextLine());

        //calculations are done
        GSM = Goals_Scored_per_Minute(goals, matches);

        MG = Minutes_per_Goal(goals, matches);

        System.out.println("Goals per match = " + GSM);
        System.out.println("Minutes per goal = " + MG);

        scanner.close();
        
        return;
    
    }

} // END class name