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
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if(((int)num.charAt(i)) % 2 != 0)
                return num.substring(0, i+1);

        }
        return "";
    }
    static int maxProduct(int[] nums) {
        int i = 0,  max_product = nums[0], product = 1, pointer = 0;
        while (i <= nums.length){
            if(i < nums.length && nums[i] != 0) {
                product *= nums[i];
                max_product = Math.max(product, max_product);
            }
            else{
                int j = pointer; // if there is next zero in an array, this pointer variable will point to next element  of that zero
                while(j < i - 1){ // because the above condition failed when nums[i] = 0 so we'll run till i - 1;
                    product /= nums[j];
                    max_product = Math.max(product, max_product);
                    j++;
                }
                pointer = i + 1;
                product = 1;
                if(i < nums.length)
                    max_product = Math.max(max_product, 0);
            }
            i++;
        }
        return max_product;
    }

    // 2nd approach : best intuition

        public int maxProductBest(int[] nums) {

            int n = nums.length;
            int l=1,r=1;
            int ans=nums[0];

            for(int i=0;i<n;i++){

                //if any of l or r become 0 then update it to 1
                l = l==0 ? 1 : l;
                r = r==0 ? 1 : r;

                l *= nums[i];   //prefix product
                r *= nums[n-1-i];    //suffix product

                ans = Math.max(ans,Math.max(l,r));

            }

            return ans;

        }
        //76. Minimum Window Substring
    public String minWindow(String s, String t) {
return "";
    }
}
