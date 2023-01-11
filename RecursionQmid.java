import java.util.Arrays;

public class RecursionQmid {
    public static void main(String[] args) {
        // 1. To check whether an array is ascending or not using recursion.
        int[] arr = {12,18,23,45,68,98,122};

        asc_or_not(arr, 0, arr.length-1);
    }

    static boolean asc_or_not(int[] arr, int start, int end){
        if(arr.length <=1) return true;
        else return asc_or_not(Arrays.copyOfRange(arr, 0, arr.length/2-1), 0, arr.length/2 -1) && (arr[end/2-1] <= arr[end/2]) && asc_or_not(Arrays.copyOfRange(arr, end/2-1, arr.length/2), end/2, end-1);
    }
}
