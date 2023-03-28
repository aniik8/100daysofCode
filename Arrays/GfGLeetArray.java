package Arrays;

import java.util.ArrayList;
import java.util.List;

public class GfGLeetArray {
    public static void main(String[] args) {

    }
    // 1. Number of occurrence : asked in google, amazon, zoho.in Gfg question

    int count(int[] arr, int n, int x) {
        int start = 0, end  = arr.length - 1;
        int left_index = Binsearch(arr, x, start, end, "left");
        if(left_index < 0) return 0;
        int right_index = Binsearch(arr, x, start, end, "right");
        return (right_index - left_index + 1);
    }
    static int Binsearch(int arr[], int target, int start,int end, String decision){
        int mid, result = -1;
        while(start <= end){
            mid = start + (end - start )/2;
            if(arr[mid] == target){
                result = mid;
                if(decision.equals("left"))
                    end = mid - 1;
                else start = mid + 1;

            }
            else if(arr[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return result;
    }
// ---------------------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------
// 2. Number of rotations in a rotated sorted array. gfg
static int findKRotation(int arr[], int n) {
    int start = 0, end = n - 1;
    while(start <= end){
        if(arr[start] <= arr[end]) return start;
        int mid = start + (end - start) / 2;
        int prev = (mid + n  - 1) % n;
        int next = (mid + 1) % n;
        if(arr[mid] <= arr[prev] && arr[mid] <= arr[next]){
            return mid;
        }
        // because element is being found in unsorted part
        else if(arr[start] <= arr[mid]){
            start = mid + 1;
        }
        else{
            end = mid - 1;
        }
    }
    return 0;
}
    // 33. Search in Rotated Sorted Array
    static int search(int[] nums, int target){
        // take out the min index first.
        int start = 0, end = nums.length - 1, mid, pivot=0;
        if(nums[start] <= nums[end]) {
            return Binarysearch(nums, target, 0, nums.length-1);
        }
        // 4,5,6,7,0,1,2
        while(start <= end){
            mid = start + (end - start)/2;
            int prev = (mid + nums.length  - 1) % nums.length;
            int next = (mid + 1) % nums.length;
            if(nums[mid] <= nums[prev] && nums[mid] <= nums[next] )
                pivot = mid;
            else if(nums[start] <= nums[mid])
                start = mid + 1;
            else end = mid - 1;
        }
        int leftsearch = Binarysearch(nums, target, 0, pivot-1);
        int rightsearch = Binarysearch(nums, target, pivot, nums.length-1);
        return Math.max(leftsearch, rightsearch);

    }
    static int Binarysearch(int[] nums, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
    // additional Question and good one
    // Search in nearly sorted array - that is like elements in an array are either at i - 1, i or i+1 position.
    static int searchInnearly(int[] arr, int target){
        int start = 0, end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == target){
                return mid;
            }if(mid - 1 >= start && arr[mid-1] == target)
                return mid - 1;
            if(mid + 1 <= end && arr[mid+1] == target)
                return mid + 1;
            else if(arr[mid] > target)
                end = mid - 2;
            else start = mid + 2;
        }
        return -1;
    }
    // Floor in a Sorted Array
    // https://practice.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1
    static int findFloor(long arr[], int n, long x)
    {
        int result = -1;
        int start = 0, end = n - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == x){
                return mid;
            }
            else if(arr[mid] > x){
                end = mid - 1;
            }else{
                result = mid;
                start = mid + 1;
            }
        }
        return result;
    }
    // ceil of a number in a sorted array.

    static int findCeil(long[] arr, int n, long x){
        int result = -1;
        int start = 0, end = n - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == x){
                if(mid + 1 < (n -1)){
                    return mid+1;
                }
                else return mid;
            }
            else if(arr[mid] > x){
                result = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return result;
    }

    // 744. Find Smallest Letter Greater Than Target
    static char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length - 1;
        char result = letters[0];
        while(start <= end){
            int mid = start + (end - start)/2;
            if(letters[mid] == target){
                start = mid + 1;
            }
            else if(letters[mid] > target){
                result = letters[mid];
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return result;
    }
    // search in an infinite sorted array..
    static int searchInInfiniteArray(int[] nums, int target){
        int start = 0, end = 1;
        int index = 0;
        while(nums[end] < target){
            start = end;
            end = end * 2;
        }
        // Do binary search from start to end; No matter what the infinite array is, we do only care about the array in
        // which our element reside.
        return index;
    }


    // Minimum Difference Element in a Sorted Array ---- Floor value of difference
    // first calculate the floor index and return the same,
    static int minDifference(int[] arr, int n, int x)
    {   int result = -1;
        int start = 0, end = n - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == x){
                return mid;
            }
            else if(arr[mid] > x){
                end = mid - 1;
            }else{
                result = mid;
                start = mid + 1;
            }
        }
        return result;
    }

    // 119 Pascal Triangle
    static List<Integer> pascalTriangle(int n){
        List<Integer> row = new ArrayList<>();
        row.add(1);
        if(n==0) {
            return row;
        }
        else{
            List<Integer> previous_row = pascalTriangle(n-1);


            for(int i =0;i < previous_row.size()-1; i++){
                int rows = previous_row.get(i) + previous_row.get(i + 1);
                row.add(rows);
            }
            row.add(1);
            return row;
        }

    }
// Bitonic arrray have similar approach as the peak element array. so questions like :
    /* "Maximum in a bitonic array and search an element in bitonic array all have same concept" */
    // 27. Remove Element
public int removeElement(int[] nums, int val) {
    int i = 0;
    for (int j = 0; j < nums.length; j++) {
        if (nums[j] != val) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
        }
    }
    return i;
}
}
