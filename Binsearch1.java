public class Binsearch2 {
    public static void main(String[] args) {
// Leetcode - 724 Find pivot element.
        int[] arr = {11, 20, 30, 40, 50, 60, 8, 9};
        System.out.print(pivot_element(arr));
// 153. Find Minimum in Rotated Sorted Array.
        System.out.print(findMin(arr));


    }


    static int pivot_element(int[] nums){
        int start = 0; int end = nums.length - 1;
        while(start < end){                                 // 11, 20, 30, '40', "50", 60, 8, 9
            int mid = (start + end)/2;                      // 10 , 11, 4, 5, 6, 7, 8
            if(nums[mid] > nums[end]){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return nums[start];
    }
    public static int findMin(int[] nums) {
        int start = 0; int end = nums.length - 1;
        while(start < end){
            int mid = (start + end)/2;
            if(nums[mid] > nums[end]){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return nums[start];
    }
}
