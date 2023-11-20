package RandomProjects;
// Adam Dahimene
// 24/10/2023
// VERSION 1
// Read and check a geometric sequence


import java.util.Scanner; // Needed to make Scanner available

class MidTerm
{
    public static void main (String [] a)
    {
        GeometricSeq();
        
        return;
    }

    //Prints a message and user inputs integer answer
    public static int InputNum(String message)
    {
        int answer;
        Scanner scanner = new Scanner(System.in);

        System.out.print(message);
        answer = Integer.parseInt(scanner.nextLine());

        return answer;
    }
    
    //If invalid number return error message
    public static void Invalid(int seq, int ratio, int input)
    {
        double WrongRatio;
        double previousNum;

        previousNum = seq / ratio; //previous number calculated

        WrongRatio = input / previousNum; //calculate wrong ratio

        System.out.println("Error, ratio between last entered is " + WrongRatio + ", which is not " + ratio + " as expected.");
        System.out.println("Ending due to error.");

        return;
    }

    //Main part of code goes through geometric sequence
    public static void GeometricSeq()
    {
        int length;
        int ratio;
        int seq; //the correct sequence of numbers
        int input;
        boolean correct = true;

        length = InputNum("Length of sequence? (n>1)  ");

        while (length <= 1) //checks whether input is >1
        {
            length = InputNum("Length of sequence? (n>1)  ");
        }

        ratio = InputNum("Common ratio?  (positive integer)  ");

        while (ratio <= 0) //checks whether input is positive
        {
            ratio = InputNum("Common ratio?  (positive integer)  ");
        }

        seq = InputNum("Enter positive integer #1:  ");

        for (int i = 2; i < length + 1; i++)
        {
            input = InputNum("Enter positive integer #" + i +":  ");

            seq = seq * ratio; //correct sequence

            if (seq != input)
            {
                Invalid(seq, ratio, input);
                correct = false;

                break; //stops code
            }
        }

        if (correct)
        {
            System.out.println("All good.");
        }

        return;
    }
}