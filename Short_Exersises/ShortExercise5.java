import java.util.Scanner;

class Module_Grade_Calculation 
{
    public static void main (String [] a)
    {
        ModuleGrade(); 
        return;
    } 
    

    public static int InputNum(String message)
    {
        int answer;
        boolean again;

        Scanner scanner = new Scanner(System.in);

        System.out.print(message);

        while (again = true)
        {
            try 
            {
                answer = Integer.parseInt(scanner.nextLine());
                again = false;
                return answer;
            }
            catch( Exception e ) 
            {
                System.out.print("Please enter an integer  ");
            }
            
        }
        answer = Integer.parseInt(scanner.nextLine());                          

        return answer;
    }

    public static String FinalGrade(int [] Earned, String [] Grades)
    {
        int sum = 0;

        if (Earned[0] == 8)
        {
            return Grades[0];
        }
        else if (Earned[0] == 7)
        {
            return Grades[1];
        }
        

        for (int i = 0; i < 7; i++)
        {
            sum = sum + Earned[i];
            if (sum >= 6)
            {
                return Grades[i+2];
            }
        }
        
        return "Q";
    }

    public static void ModuleGrade()
    {
        String total;
        int amount;
        final int AMOUNT_OF_GRADES = 7;
        int [] Earned = new int[AMOUNT_OF_GRADES];
        String [] Grades = {"A*","A++","A+", "A", "B", "C", "D", "F", "G"};

        for (int i = 0; i < AMOUNT_OF_GRADES; i++)
        {
            amount = InputNum("How many " + Grades[i+2] + " grades did you get?  ");

            Earned[i] = amount;

        }
        total = FinalGrade(Earned, Grades);

        System.out.println("You consistently gained a " + total + " grade or better.");
        System.out.println("Therefore you gained a " + total + " grade overall.");
    }
}