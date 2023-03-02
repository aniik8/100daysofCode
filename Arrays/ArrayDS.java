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
        HashSet<Integer> map = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.contains(nums[i]))
                map.remove(nums[i]);
            else map.add(nums[i]);
        }
        System.out.println(map);
        int j = 1;
        for (int a : map) {
            if (j == k)
                return a;
            j++;
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

