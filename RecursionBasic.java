public class RecursionBasic {
    public static void main(String[] args) {
        //Basic easy programs that uses concept of recursion..
        // 1. Print fibonacci number
        System.out.println((fib(5)));
        // 2. Print first 50 natural numbers using recursion in descending order
        printNN(50);
        // 3. Program to print  the sum of numbers from 1 to n using recursion
        System.out.println(SumOfN(50));
        // 4. GCD of a number using recursion
        System.out.println(gcd(27, 48));
        // 5. element of an array
        int[] arr = {12, 13, 15, -1, 19, 0, 2, -2};
        printArray(arr,0);
        // 6. sum of a digit of a number using recursion.
        System.out.println(sumOfdigit(199));
        // 7. largest element in an array
        System.out.println(largestArray(arr, 0, 0));
        // 8. Prime number or not
        System.out.println(primeOrnot(1923, 1923/2));
    }

    public static int fib(int n) {
        if(n < 2) {

            return n;
        }
        else{

            return (fib(n-1) + fib(n-2));
        }
    }
    // 2.
    public static void printNN(int n){
        if(n>0) {
            System.out.print(n + " ");
            printNN(n - 1);
        }
    }
    // 3.
    public static int SumOfN(int n) {
        if(n < 2){
            return n;
        }else return n + SumOfN(n-1);

    }

    // 4. GCD
    public static int gcd(int n1, int n2){
        while(n1 != n2){
            if(n1 > n2){
                return gcd(n1-n2, n2);
            }
            else return gcd(n1,n2-n1);
        }
        return n1;
    }
    // 5. element of an array
    public static void printArray(int[] arr,int n){
        if(n < arr.length){
            System.out.print(arr[n] + "  ");
            printArray(arr, n+1);
        }
    }
    // 6. sum of a digit of a number using recursion.
    public static int sumOfdigit(int n){
        if(n < 10){
            return n;
        }
        else return sumOfdigit(n%10) + sumOfdigit(n/10);
    }

    // 7. print largest element of an array using recursion.
    public static int largestArray(int[] arr, int max, int n){
        if(n == arr.length){
            return max;
        }else if(arr[n] > max){
            return largestArray(arr, arr[n], n+1);
        }
        return largestArray(arr, max, n+1);
    }
    // 8. Prime or not
    public static int primeOrnot(int n, int i){
        if(i == 1){
            return 0;
        }else if(n % i != 0) return primeOrnot(n, i-1);
        else return 1;
    }


}
