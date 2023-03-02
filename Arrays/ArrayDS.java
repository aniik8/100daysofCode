package Arrays;

import java.util.Arrays;
import java.util.HashMap;
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
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }
            else{
                map.put(nums[i], 1);
            }
        }
        // if distinctkey == k noew here we'll declare the distinct key var as 0
        int distinctkey = 0;
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == 1)
                distinctkey++;
            if(distinctkey == k){
                return nums[i];
            }
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

