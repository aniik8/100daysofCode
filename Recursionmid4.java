import java.util.Arrays;

public class Recursionmid4 {
    public static void main(String[] args) {
        int[] arr = {1, 2 ,3, 4, 5, 6};
        //1. skipping a character from a string

        System.out.println(skipaChar("baccad", 'a', 0));
        //2. writing different substring of a given string
        substring("abc", "");
        // 3. permutation of a string using recursion
        permutataionString("abc", "");
        // 4. Addition of two using recursion
        slow_addition(13, 21);
        // 5. Decimal to binary conversion using recursion
        System.out.println(decimal_binary(39));
        // 6. Decimal to any base conversion using recursion
        System.out.println(decimal_to_any(34, 5));
        // 7. GCD using Euclid's division
        System.out.print(euclid_gcd(132, 144));
        // 8. Check whether an array is ascending or not
        System.out.println(asc_or_not(arr, 0, arr.length-1));
    }

    static String skipaChar(String sc, char ch, int len){
        if(sc.length()==0){
            return "";
        }
        else{
            if(sc.charAt(0) != ch) return "" + sc.charAt(0) + skipaChar(sc.substring(len+1), ch,0);
            else return ""  + skipaChar(sc.substring(len+1), ch,0);
        }
    }

    // 2.
    static void substring(String sc, String left){
        if (sc.length()==0) {
            System.out.println(left);
            return;
        }
        substring(sc.substring(1), left+sc.charAt(0));
        substring(sc.substring(1), left);
    }
    // 3.
    static void permutataionString(String sc, String left){
        if(sc.length() == 0){
            System.out.println(left);
            return;
        }
        for (int i = 0; i <= sc.length(); i++) {
            String first = sc.substring(0, i);
            String second = sc.substring(i, sc.length());
            permutataionString(sc.substring(1), first+sc.charAt(0)+second);
        }
    }
    // 4. addition of two numbers using recursion
    static int slow_addition(int a, int b){
        if(a == 0) return b;
        else if(b==0) return a;
        else if(a < b) return slow_addition(a-1, b)+1;
        else return slow_addition(a-1, b)+1;
    }
    // 5. Decimal to binary conversion using recursion
    static int decimal_binary(int n){
        if(n < 2) return 1;
        else return 10 * decimal_binary(n/2) + (n%2);
    }
    static int decimal_to_any(int n, int base){
        if(n < 2) return 1;
        else return 10 * decimal_to_any(n/base, base) + (n%base);
    }
// Hoare's algorithm for partitioning an array
    static int[] hoare_swap(int[] arr2, int start, int end){
        int mid = start + (end - start) /2;
        int temp = arr2[mid];
        arr2[mid] = arr2[0];
        arr2[0] = temp;

        return hoare_partitioning(arr2, 1, end, 0);
    }
    static int[] hoare_partitioning(int[] arr2, int left, int right, int pivot){
        if(left > right){
            // swap the pivot element with the original first element.
            int mid = arr2.length/2;
            int temp = arr2[mid];
            arr2[mid] = arr2[0];
            arr2[0] = temp;
            return arr2;
        }
        else if(arr2[left] >= arr2[pivot] && arr2[right] < arr2[pivot]){
            // swap left and right elements
            int temp = arr2[left];
            arr2[left] = arr2[right];
            arr2[right] = temp;
            return hoare_partitioning(arr2, left+1, right-1, pivot);

        }
        else {
            if (arr2[left] < arr2[pivot]) {
                left++;
            }
            if (arr2[right] > arr2[pivot]) {
                right--;
            }
            return hoare_partitioning(arr2, left, right, pivot);
        }
    }
    static double f(double x){
        return (x*x-9);
    }
    static double bisection_method(double a, double b, double epsilon){
        double z = (a+b)/2;
        if((f(z) == 0) || (b-a) <= 2* epsilon){
            return z;
        }else if((f(a) > 0 && f(z) < 0) || (f(a) <0 && f(z) > 0)){
            return bisection_method(a, z, epsilon);
        }else{
            return bisection_method(z, b, epsilon);
        }
    }


    public static int euclid_gcd(int n1, int n2){
        if(n1 == 0) return n2;
        else if(n1 > n2) return euclid_gcd(n2, n1);
        else return euclid_gcd(n1, n2-n1);
    }
    // check whether an array is ascending or not using recursion
    static boolean asc_or_not(int[] arr, int start, int end){
        if(arr.length <=1) return true;
        else return asc_or_not(Arrays.copyOfRange(arr, 0, arr.length/2-1), 0, arr.length/2 -1) && (arr[end/2-1] <= arr[end/2]) && asc_or_not(Arrays.copyOfRange(arr, end/2-1, arr.length/2), end/2, end-1);
    }
    // checking if a string is palindrome or not...
    static boolean is_palindrome(String str, int i, int j){
        if(i > j){
            return true;
        }
        else if(str.charAt(i) == str.charAt(j)){
            return is_palindrome(str, i+1, j-1);
        }else return false;
    }
    // largest substring of a string
    static String largest_substring(String str, int i , int j){
        if (is_palindrome(str, i, j-2)) return str;
        else{
            String s1 = largest_substring(str.substring(i, str.length()-1), 1, str.length()-1);
            String s2 =  largest_substring(str.substring(i, str.length()-2), 0, str.length()-2);
            if(s1.length() > s2.length()) return s1;
            else return s2;
        }
// forgeeksskeegfor
    }
}
