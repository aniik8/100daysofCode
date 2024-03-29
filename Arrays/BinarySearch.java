import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {

    }
// 1. Function to perform basic binary search...
    public static int binarysearch(int[] arr, int ele){
        int start = 0, end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(ele == arr[mid]){
                System.out.println("h ");
                return mid;
            }
            else if(ele > arr[mid]){
                start = mid + 1;
            }
            else if(ele < arr[mid]){
                end = mid - 1;
            }
        }
        return -1;
    }

// LeetCode Problem 69. Square root of a number using binary search
public static int sqroot(double x){
    double start = 0, end = x;               // square root
    double mid = (start + end)/2;
    double square;
    if(x==1){
        return 1;
    }
    while(start <= end){
        mid = (start + end)/2;
        square = (Math.pow(mid,2));

        if(Math.floor(square) == x){
            return (int)Math.floor((mid));
        }
        else if(square < x){
            start = mid;
        }
        else if(square > x){
            end = mid;
        }

    }
    return (int)mid;
}
// LeetCode problem 33. Search in a rotated array using binary search.
    public static int rotated_array(int[] rotated_arr){     // {8, 10,11, 12, 14, 16, "19", 25, 0,1, 2, 4, 6}
        int low = 0, high = rotated_arr.length - 1;
        int n = rotated_arr.length;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int prev = (mid - 1 + n) % n;
            int next = (mid + 1) % n;

            if (rotated_arr[mid] <= rotated_arr[prev]
                    && rotated_arr[mid] <= rotated_arr[next])
                return mid;
            else if (rotated_arr[mid] <= rotated_arr[high])
                high = mid - 1;
            else if (rotated_arr[mid] >= rotated_arr[low])
                low = mid + 1;

        }
        return 0;
    }

// Leetcode 162 Peak index
public static int findPeakElement(int[] nums) {
    int start=0; int end = nums.length-1;

    while (start <=end){
        int mid = (start + end)/2;
        if(start >= nums.length-1){
            return start;
        }
        if(nums[mid] > nums[mid+1]){
            end = mid -1;
        }else {
            start = mid + 1;
        }
    }
    return start;
}
    public static boolean isPerfectSquare(int num) { // 36
        int start = 0, end = num;
// https://leetcode.com/problems/valid-perfect-square/submissions/851343557/

        if(num == 1) return true;
        while(start <= end){
            int mid = start + (end-start)/2;
            int square = (int) Math.pow(mid,2);
            if(square == num){
                return true;
            }
            else if(square > num){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return false;
    }
//    Given a sorted array and a target sum, check if you can search a pair of three elements such that
//        the sum of three elements will be equal to the target sum
    public static int[] searchSumThree(int[] arr, int target){
        int third_element = 0;
        int[] copy = new int[3];
        for (int i = 0; i < arr.length; i++) {
            int first = arr[i];
            for (int j = i+1; j < arr.length - 1; j++) {
                int second = arr[j];
                if(arr[i] + arr[j] >= target)
                    break;
                third_element = binarysearch(arr, target - (first+second));
                if(third_element == -1) continue;
                else{
                    System.out.println("tripled found");

                    copy[0] = first;
                    copy[1] = second;
                    copy[2] = third_element;
                    return copy;
                }
            }


        }
        return copy;
    }
    //1095 LEETCODE
    public static int findInMountainArray(int target, int[] arr) {
        int start=0; int end = arr.length-1;

        while (start <=end){
            int mid = (start + end)/2;
            if(start >= arr.length-1){
                return start;
            }
            if(arr[mid] > arr[mid+1]){
                end = mid -1;
            }else {
                start = mid + 1;
            }
        }
        int peak = start;
        int num  = binarysearch(arr, target, 0, peak);
        if(num != -1) return num;
        else {
            return binarySearchTwo(arr, peak+1,  arr.length - 1, target);
        }

    }
    public static int binarysearch(int[] arr, int ele, int start, int end){
        while(start <= end){
            int mid = start + (end - start)/2;
            if(ele == arr[mid]){
                return mid;
            }
            else if(ele > arr[mid]){
                start = mid + 1;
            }
            else if(ele < arr[mid]){
                end = mid - 1;
            }
        }
        return -1;
    }
    static int binarySearchTwo(int arr[], int start, int end, int x)
    {

        boolean isAsc = arr[start] < arr[end];
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (arr[middle] == x)
                return middle;
            if (isAsc == true) {
                if (arr[middle] < x)
                    start = middle + 1;
                else
                    end = middle - 1;
            }

            else {
                if (arr[middle] > x)
                    start = middle + 1;
                else
                    end = middle - 1;
            }
        }
        return -1;
    }
//    167. Two Sum II - Input Array Is Sorted
public static int[] twoSum2(int[] numbers, int target) {
    // it uses binary search but with addition to some thing more

    for (int i = 0; i < numbers.length; i++) {
        int start = i+1, end = numbers.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(numbers[mid] == (target-numbers[i]))
                return new int[]{i+1, mid+1};
            else if(numbers[mid] > (target-numbers[i]))
                end = mid - 1;
            else start = mid+1;
        }
    }
    return new int[]{-1, -1};
}
    // two pointers approach // tc o(n)
    public static int[] twosumTwo(int[] nums, int target){
        int j = nums.length-1, i = 0;
        System.out.println(j+ " ,  " + i );
        while(i < j){
            if(nums[i] == (target - nums[j]))
                return new int[]{i+1, j+1};
            else if(nums[i] < (target - nums[j]))
                i++;
            else j--;
        }
        return new int[] {-1, -1};
    }
    // 941. valid Mountain Array
    public static boolean validMountainArray(int[] arr){
        int start = 0; int end = arr.length - 1;
        int peak;
        while(start <= end){
            int mid = start + (end - start) /2;
            if(start >= arr.length-1) break;
            else if(arr[mid] == arr[mid+1]) return false;
            else if(arr[mid] > arr[mid+1])
                end = mid - 1;
            else
                start = mid + 1;
        }
        peak = start;
        System.out.println(arr[peak]);
        for (int i = 0; i < peak; i++) {
            if(arr[i] >= arr[i+1]) return false;
        }
        for (int i = peak; i < arr.length-1; i++) {
            if(arr[i] <= arr[i+1]) return false;
        }
        return true;
    }
    public static int longestMountain(int[] arr){
        // find the peak element
        int start = 0, end = arr.length - 1;
        int count = 0;
        while(start <= end){
            int mid = (start + end)/2;
            if(start >= arr.length-1) break;
            if(arr[mid] > arr[mid+1])
                end = mid - 1;
            else if (arr[mid] < arr[mid+1])
                start = mid + 1;
            else break;
        }
        if(start == 0 || start == arr.length - 1) return 0;
        int peak = start;
        for (int i = peak; i > 0; i--) {
            if(arr[i] > arr[i-1]) {
                count++;
            }
            else break;
        }
        for (int j = peak; j < arr.length-1; j++) {
            if(arr[j] > arr[j+1]) {
                count++;
            }else break;
        }

        return (count+1);
    }
}
class Solutions {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] arr = new int[1001];
        int n = 0;
        Arrays.sort(nums2);
        for (int j : nums1) {
            int element = binarySearch(j, nums2);
            if (element != -1) {
                arr[n] = element;
                n++;
            }
        }
        return Arrays.copyOfRange(arr, 0, n);
    }
    int binarySearch(int target, int[] arr){
        int start = 0, end = arr.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] == target)
                return target;
            else if(arr[mid] > target)
                end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }
    static int[] intersect22(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> h = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++)
        {
            if(h.containsKey(nums1[i])) h.put(nums1[i], h.get(nums1[i])+1);
            else h.put(nums1[i], 1);
        }

        for(int i = 0; i < nums2.length; i++)
        {
            if(h.containsKey(nums2[i]) && h.get(nums2[i]) > 0)
            {
                res.add(nums2[i]);
                h.put(nums2[i], h.get(nums2[i])-1);
            }
        }

        int[] arr = new int[res.size()];
        for(int i = 0; i < res.size(); i++)
        {
            arr[i] = res.get(i);
        }

        return arr;
    }
    // 268 Missing Number BruteForce
    public int missingNumberBruteForce(int[] nums) {
        Arrays.sort(nums);
        int i;
        for(i = 0; i < nums.length; i++)
        {
            if(nums[i] != i)
                return i;
        }
        return i;
    }
    // Using Maths 0 ms beats 100%
    public int missingNumberMaths(int[] nums) {
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += i;
        }

        for (int a :
                nums) {
            sum -= a;
        }
        return sum;
    }
    // using Hashset
    public int missingNumberHashSet(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int i;
        for (int num : nums) {
            hashSet.add(num);
        }
        for (i = 0; i <= nums.length; i++) {
            if(!(hashSet.contains(i)))
                return i;
        }
        return i;
    }
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        int i = 0, j = 0, sum = 0, max = Integer.MIN_VALUE;
        while(j < Arr.size()){
            sum += Arr.get(j);
            if((j - i + 1) < K)
                j++;
            else if((j - i + 1) == K) {
                max = Math.max(sum, max);
                sum -= Arr.get(i);
                i++;
                j++;
            }
        }
        return max;
    }
    // bruteforce solution
    // 209. Minimum Size Subarray Sum
    static int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0, sum = 0;
        int length= 0, minLength = Integer.MAX_VALUE;

        while(j < nums.length){
            sum += nums[j];
            if(sum >= target){
                length = j - i + 1;
                minLength = Math.min(minLength, length);
                i++;
                j = i;
                sum = 0;
            }
            else{
                j++;
            }

        }
        if(minLength == Integer.MAX_VALUE) return 0;
        else return minLength;
    }
    //
    static long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        ArrayList<Long> list = new ArrayList<>();
        Stack<Long> stack = new Stack<>();
        long[] arr = new long[N-K+1];
        int i = 0, j = 0, a = 0;
        while(j < A.length){
            if(A[j] < 0)
                list.add(A[j]);
            if((j - i + 1) < K){
                j++;
            }
            else if((j - i + 1) == K){
                if(list.size() == 0)
                    list.add(0L);
                else{
                    arr[a] = list.remove(j);
                    a++;
                    i++; j++;
                }
            }
        }
        return arr;
    }
    static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){

            if(map.containsKey(nums[i])){
                if(Math.abs(map.get(nums[i])-i)<=k)return true;
                else map.put(nums[i],i);

            }
            else{
                map.put(nums[i],i);
            }

        }
        return false;
    }
    // sub array size equal to k for positive number
    static int subarraySum(int[] nums, int k) {
        int i = 0, j = 0;
        int sum = 0, count = 0;
        while(j < nums.length){
            sum += nums[j];
            if(sum < k)
                j++;
            else if(sum == k) {
                count++;
                sum -= nums[i];
                i++;
                j++;
            }
            else {
                while(sum > k)
                {
                    sum -= nums[i];
                    i++;
                }
                j++;
            }
        }
        return count;
    }
    // actual solution of subarray sum = k problem
    static int subarraysSum(int[] nums, int k) {
        int sum = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if(((int)num.charAt(i)) % 2 != 0)
                return num.substring(0, i+1);

        }
        return "";
    }
//    public String minWindow(String s, String t) {
//        return "";
//    }
// 28. Find the Index of the First Occurrence in a String
    static int strStr(String haystack, String needle) {
        int i = 0;
        if(haystack.contains(needle)){
            return haystack.indexOf(needle);
        }
        return -1;
    }
    // 58. Length of Last Word

    public int lengthOfLastWord(String s) {
        int i = s.length()-1, count = 0;

        while(s.charAt(i) != ' '){
            count++;
            i--;
        }
        return count;
    }

    // 904. Fruit Into Baskets
    static int totalFruit(int[] fruits) {
        //  3,3,3,1,2,1,1,2,3,3,4
        int i = 0, j = 0, max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        if(fruits.length < 3) return fruits.length;
        while(j < fruits.length){
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            while(map.size() > 2){
                map.put(fruits[i], map.get(fruits[i])-1);
                if(map.get(fruits[i]) == 0) {
                    map.remove(fruits[i]);
                }
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }

        return max;
    }
}

