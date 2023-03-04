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
}
