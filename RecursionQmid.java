import java.util.ArrayList;
import java.util.Arrays;

public class RecursionQmid {
    public static void main(String[] args) {
        // 1. To check whether an array is ascending or not using recursion.
        int[] arr = {12,18,23,45,68,98,122};
        int[] arr2 = {2, 1, 1, 1, 1,0, 1, 2, 3,4,5,6};

        // 2. Counting a particular element of an array.
        asc_or_not(arr, 0, arr.length-1);
        System.out.println(count_the_occurance(arr2, 1));

        // 3. counting majority element using boyer moore voting algo.
        System.out.println(majority_element(arr2, arr2.length, 0, 0, 0));
        
        tower_of_hanoi(4, '0', 'D', 'A');

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
    public static void printArray(int[] arr,int n){
        if(n < arr.length){
            System.out.print(arr[n] + "  ");
            printArray(arr, n+1);
        }
    }
// tower of hanoi
    static void tower_of_hanoi(int n, char o, char d, char a){
        if(n == 1) System.out.println(n + " from " + o + " to  " + d);
        else{
            tower_of_hanoi(n-1, o, a, d);
            System.out.println(n + " from " + o + " to  " + d);
            tower_of_hanoi(n-1, a, d, o);
        }
    }
    static void tower_of_hanoi_leetcode(int n){
        if(n == 1) System.out.println(n);
        else{
            tower_of_hanoi_leetcode(n-1);
            System.out.println(n);
            tower_of_hanoi_leetcode(n-1);
        }
    }
    //
    // Function to remove adjacent duplicates characters from a stri
        public static String removeDuplicates(String s)
        {
            // base case
            if (s == null) {
                return null;
            }

            char[] chars = s.toCharArray();
            char prev = 0;
            int k = 0;

            for (char c: chars)
            {
                if (prev != c)
                {
                    chars[k++] = c;
                    prev = c;
                }
            }

            return new String(chars).substring(0, k);
        }
    static void print_array_subsequence(int[] arr, ArrayList<Integer> up){
        if(arr.length == 0){
            System.out.println(Arrays.toString(arr));
            return;
        }
        int ele = arr[0];

        print_array_subsequence(Arrays.copyOfRange(arr), );
    }


    }
}
