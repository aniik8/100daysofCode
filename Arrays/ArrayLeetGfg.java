package Arrays;

import java.util.*;

public class ArrayLeetGfg {
    public static void main(String[] args) {

        int[] nus = {2147483647,1,2,3,4,5,6,7,2147483647};
        System.out.println(Arrays.toString(medianSlidingWindow(nus, 2)));
//        System.out.println(Integer.MAX_VALUE);
    }
    static double[] medianSlidingWindow(int[] nums, int k) {

        double[] result;
        if(k % 2 != 0) result = ifKodd(nums, k);
        else result = ifKeven(nums, k);
        return result;
    }
    static double[] ifKodd(int[] nums, int k){
        int i = 0, j = 0, num = 0;
        double[] result = new double[nums.length - k + 1];
        int[] temp = new int[k];
        while(j < nums.length){
            if((j - i + 1) < k){
                j++;
            }
            else if((j - i) + 1 == k){
                temp = Arrays.copyOfRange(nums, i, j+1);
                Arrays.sort(temp);

//                System.out.println(Math.ceil((i+j)/2));
                result[num++] = (double)temp[k/2];
                i++;j++;
            }
        }
        return result;
    }
    static double[] ifKeven(int[] nums, int k){
        int i = 0, j = 0, num = 0;
        double[] result = new double[nums.length - k + 1];
        int[] temp = new int[k];
        while(j < nums.length){
            if((j - i + 1) < k){
                j++;
            }
            else if((j - i) + 1 == k){
                temp = Arrays.copyOfRange(nums, i, j+1);
                Arrays.sort(temp);
//                System.out.println(Math.ceil((i+j)/2));
                result[num++] =((double)(temp[k/2])/2) + ((double)(temp[(k/2) - 1])/2);
                i++;j++;
            }
        }
        return result;
    }
    // 53. Maximum Subarray
    static int maxSubArray(int[] nums) {
        int i = 0, j = 0, sum = 0;
        int max_sum = Integer.MIN_VALUE;
        while(j < nums.length){
            if(sum <= 0 && nums[j] >= sum){
                i = j;
                sum = 0;
            }
            sum += nums[j];
            max_sum = Math.max(sum, max_sum);
            j++;
        }
        return max_sum;
    }
}
