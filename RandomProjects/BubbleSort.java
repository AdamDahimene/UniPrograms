package RandomProjects;

class BubbleSorted
{
    public static void main(String[] args)
    {
        BubbleSort();

        return;
    }

    public static void printArr(int[] nums)
    {
        final int LENGTH = nums.length - 1;

        for(int i = 0; i < LENGTH; i++)
        {
            System.out.print(nums[i] + ", ");
        }

        System.out.println(nums[LENGTH]);

        return;
    }

    public static boolean check(int[] nums)
    {
        for(int i = 0; i < nums.length - 1; i++)
        {
            if(!(nums[i] <= nums[i + 1]))
            {
                return false;
            }
        }

        return true;
    }

    public static void BubbleSort()
    {
        int middleman;
        int[] numbers = {5, 7, 3, 45, 457, 25, 769, 436, 325, 123, 9674};
  

        while(!check(numbers))
        {
            for(int i = 0; i < numbers.length - 1; i++)
            {
                if(numbers[i] > numbers[i + 1])
                {
                    middleman = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = middleman;
                }
            }

            printArr(numbers);
        }

        System.out.println("Sorted");
        
    }
}
