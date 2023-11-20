
//messages and grade input
//gives best grade for each part
// calculate best grade
import java.util.Scanner;

class name
{
    public static void main (String [] a)
    {
        TestGrade();

        return;
    }
    
    // Prints message and asks user for int input and returns
    public static int InputNum(String message)
    {
        int number;
        final String options = "   1)A+  2)A  3)B  4)C  5)D  6)F  7)G"; //Constant options

        Scanner scanner = new Scanner(System.in);

        System.out.println(message + options);
        number = Integer.parseInt(scanner.nextLine()); //String to int


        return number;
    }

    //All grade options
    public static String Grade(int num)
    {
        if (num == 1)
        {
            return "A+";
        }
        else if (num == 2)
        {
            return "A";
        }
        else if (num == 3)
        {
            return "B";
        }
        else if (num == 4)
        {
            return "C";
        }
        else if (num == 5)
        {
            return "D";
        }
        else if (num == 6)
        {
            return "F";
        }
        else
        {
            return "G";
        }
    }

    //Calculate final grade by checking which grade is bigger by comparing number input
    public static int FinalGrade(int num1 , int num2)
    {
        if (num1 > num2)
        {
            return num2;
        }
        else if (num1 < num2)
        {
            return num1;
        }
        else
        {
            return num1;
        }

    }

    //main code where to store values and print
    public static void TestGrade()
    {
        //Variables to store inputs T for theory, D for dry run and P for program
        int Tgrade1;
        int Dgrade1;
        int Pgrade1;

        int Tgrade2;
        int Dgrade2;
        int Pgrade2;

        int Final_Tgrade;
        int Final_Dgrade;
        int Final_Pgrade;


        Tgrade1 = InputNum("Test 1: What is your 1st theory grade?");
        Dgrade1 = InputNum("Test 1: What is your 1st dry run grade?");
        Pgrade1 = InputNum("Test 1: What is your 1st program grade?");

        System.out.println("Your grades were " + Grade(Tgrade1) +" "+ Grade(Dgrade1) +" "+ Grade(Pgrade1)); //turns number input to grades

        Tgrade2 = InputNum("Test 2: What is your 2st theory grade?");
        Dgrade2 = InputNum("Test 2: What is your 2st dry run grade?");
        Pgrade2 = InputNum("Test 2: What is your 2st program grade?");

        System.out.println("Your grades were " + Grade(Tgrade2) +" "+ Grade(Dgrade2) +" "+ Grade(Pgrade2));

        Final_Tgrade = FinalGrade(Tgrade1, Tgrade2);
        Final_Dgrade = FinalGrade(Dgrade1, Dgrade2);
        Final_Pgrade = FinalGrade(Pgrade1, Pgrade2);

        System.out.println("Your final three test grades are Theory: " + 
            Grade(Final_Tgrade) + ", Dry Run: " + Grade(Final_Dgrade) + ", Program: " + Grade(Final_Pgrade));


        return;
    }

}