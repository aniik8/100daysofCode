public class Recursionmid {
    public static void main(String[] args) {
// 1. fibonacci number
        System.out.println(fib(5));
// 2. fibonacci series till n
        System.out.println(fibo(10, 0,1, 1, 0));
// 3. reverse a string using recursion
        System.out.println(reverseString("aniket", 6));
// 4. Binary search algorithm using recursion
        int[] arr = {-20, -2, 1, 6, 7, 9, 12, 15, 19, 21};
        System.out.println(BinarySearch(arr, 0, arr.length-1, 15));

    }
    public static int fib(int n) {
        if(n < 2) {

            return n;
        }
        else{

            return (fib(n-1) + fib(n-2));
        }
    }
    public static int fibo(int n, int first, int second, int third, int count){
        if(n == count){

            return third;
        }
        else {
            // 1
            System.out.print(first+second  + " ");
            return fibo(n, second, third, first + second, count + 1);
        }

    }
    public static String reverseString(String sc, int len){
        if(len == 0)
            return "" + sc.charAt(len);
        else return ""+ sc.charAt(len) + reverseString(sc, len-1);
    }


    public static int BinarySearch(int[] arr, int start, int end, int target){
        int mid = start + (end - start) /2;
        if(mid < start || mid > end) return -1;
        if(target == arr[mid]){
            return mid;
        }
        else if(target > arr[mid]){
            return BinarySearch(arr, mid+1, end, target);

        }
        else if(target < arr[mid])
        {return BinarySearch(arr, start, mid-1, target);
        }
        else return -1;
    }



}
