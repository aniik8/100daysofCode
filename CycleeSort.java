import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CycleeSort {
    public static void main(String[] args) {
        int[] arr2 = {1,2,3,4,4,6,7,7,9,10};
// Leetcode 448. Find disappeared element in an array
        System.out.println((findDisappearedNumbers(arr2)));
// Leetcode 442. Find duplicate element in an array.
        System.out.println(findDuplicates(arr2));
// Leetcode 287. Find the Duplicate Number
        System.out.println(findDuplicate(arr2));
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer>ans = new ArrayList<>();
        int i = 0;
        while(i < nums.length){
            int correct_pos =  nums[i] - 1;
            if(nums[i]  != nums[correct_pos])
            {
                int temp = nums[i];
                nums[i] = nums[correct_pos];
                nums[correct_pos] = temp;

            }else {
                i++;
            }

        }

        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j+1)
                ans.add(j+1);
        }
        return ans;
    }
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer>ans = new ArrayList<>();
        int i =0;
        while(i < nums.length){
            int correct_pos = nums[i] - 1;
            if(nums[i] != nums[correct_pos]){
                int temp = nums[correct_pos];
                nums[correct_pos] = nums[i];
                nums[i] = temp;
            }
            else i++;
        }
        System.out.println(Arrays.toString(nums));
        for (int j = 1; j <= nums.length; j++) {
            if(nums[j-1] != j){
                ans.add(nums[j-1]);
            }
        }
        return ans;
    }
     static int findDuplicate(int[] nums) {
        int i =0;

        while(i < nums.length){
            int correct_index = nums[i] - 1;
            if (nums[i] != nums[correct_index])
            {
                int temp = nums[correct_index];
                nums[correct_index] = nums[i];
                nums[i] = temp;
            }
            else i++;
        }
        for (int j = 1; j < nums.length; j++) {
            if(nums[j-1] < j){
                return nums[j-1];
            }
        }
        return nums[nums.length-1];
    }
}
