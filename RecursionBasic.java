public class RecursionBasic {
    public static void main(String[] args) {
        //Basic easy programs that uses concept of recursion..
        // 1. Print fibonacci number
        System.out.println((fib(5)));
        // 2. Print first 50 natural numbers using recursion in descending order
        printNN(50);
        // 3. Program to print  the sum of numbers from 1 to n using recursion
        System.out.println(SumOfN(50));
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
}
