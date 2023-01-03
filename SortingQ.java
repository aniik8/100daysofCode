import java.util.Arrays;

public class SortingQ {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 13, 18, 19, 15, 22, 29, 39, 7, 6, 5, 4, 3, 2, 0};
        // 1. Bubble-Sort
        bubblesort(arr);
        // 2. Selection sort
        selectionSort(arr);

        //3. Leetcode 1365. How Many Numbers Are Smaller Than the Current Number
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(arr)));
    }
    public static void bubblesort(int[] arr){

        // [3, 6, 7, 9, 12, 18, 45]
        int temp;
        boolean sortec = true;
        for (int i = 0; i < arr.length; i++) {
            for(int j = 1; j < arr.length - i; j++) {
                if(arr[j-1] > arr[j])
                {
                    sortec = false;
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
            if(sortec) break;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void selectionSort(int[] arr)
    {// {8,2, 9, 12, 7, 18, 45};
        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i+1; j < arr.length; j++)
                if(arr[j] < arr[min])
                    min = j;

            swap(arr, i, min);



        }
        System.out.println(Arrays.toString(arr));
    }
    // Helper function swap
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        // 8,1,2,2,3 ---> 1, 2, 2, 3, 8
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length ; j++)
                if (nums[i] > nums[j]) count++;

            arr[i] = count;
        }
        return arr;
    }


}
