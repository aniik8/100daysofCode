package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class ArrayDS {
    public static void main(String[] args) {
        // Two sum leetcode Questions.
        // 1. Two Sum bruteforce Solution
        int[] nums = {3,3};
        System.out.println(Arrays.toString(twoSum(nums, 6)));



    }
    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++){
                if(target - nums[i] == nums[j]){
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return arr;
    }
    public static int KthDistinct(int[] nums, int k) {
        HashSet<Integer> hashmap = new HashSet<>();
        for (int num : nums)
        {
            hashmap.add(num);
        }
        System.out.println(hashmap);
        int i = 0;
        for (int a : hashmap) {
            if (i == k)
                return a;
            else i++;


        }

        return -1;
    }

    // kth largest gfg
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            pq.add(nums[i]);
        }
        for(int i = k; i < nums.length; i++){
            if(pq.peek() < nums[i]){
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }

}

