package RandomProjects;

public class QuickSort
{
    public static void main(String[] args)
    {
        int[] numbers = {10, 7, 8, 6, 1, 4, 3, 2, 5, 9};
        int left = 0;
        int right = numbers.length - 1;

        printArr(numbers);

        Sort(numbers, left, right);

        printArr(numbers);

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

    public static int search(int pivot, int[] nums)
    {
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == pivot)
            {
                return i;
            }
        }
        return 0;
    }
    
    public static void Sort(int[] nums, int left, int right)
    {
        if(left >= right){
            return;
        }

        int pivot = nums[(left + right) / 2];

        while(left < right)
        {
            while((nums[left] < pivot) && (left <= right))
            {
                left++;
            }

            while(nums[right] > pivot && (left <= right))
            {
                right--;
            }

            int middleman = nums[left];
            nums[left] = nums[right];
            nums[right] = middleman;
        }

        printArr(nums);
        
        int place = search(pivot, nums);

        for(int i = 0; i < nums.length; i++)
        {
            left++;
            right = nums.length -1;

            Sort(nums, left, right);

            if(check(nums))
            {
                return;
            }
        }
        

        return;
    }
}
