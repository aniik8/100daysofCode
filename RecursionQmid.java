import java.util.Arrays;

public class RecursionQmid {
    public static void main(String[] args) {
        // 1. To check whether an array is ascending or not using recursion.
        int[] arr = {12,18,23,45,68,98,122};
        int[] arr2 = {2, 1, 1, 1, 1,0, 1, 2, 3,4,5,6};

        // Counting a particular element of an array.
        asc_or_not(arr, 0, arr.length-1);
        System.out.println(count_the_occurance(arr2, 1));
    }

    static boolean asc_or_not(int[] arr, int start, int end){
        if(arr.length <=1) return true;
        else return asc_or_not(Arrays.copyOfRange(arr, 0, arr.length/2-1), 0, arr.length/2 -1) && (arr[end/2-1] <= arr[end/2]) && asc_or_not(Arrays.copyOfRange(arr, end/2-1, arr.length/2), end/2, end-1);
    }
    // counting a particular element of an array
    static int count_the_occurance(int[] x, int n){
        if(x.length == 0) return 0;
        else return ((x[0] == n) ? 1 : 0) + count_the_occurance(Arrays.copyOfRange(x, 1, x.length), n);
    }
    static int majority_element(int[] x, int n, int i, int count, int majority){

        if(n == 0){
            return majority;
        }
        else{
            if(count == 0) majority = x[i];
            if(x[i] == majority) {
                count++;
            }else{
                count--;
            }
            return (majority_element(x, n - 1, i + 1, count, majority));

        }
    }
}
