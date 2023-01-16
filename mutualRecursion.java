public class mutualRecursion {
    public static void main(String[] args) {
        System.out.println(isEven(8));
    }

    // number odd or even using mutual recursion
    static boolean isOdd(int n){
        if(n == 0) return false;
        else return isEven(n-1);
    }
    static boolean isEven(int n){
        if(n == 0) return true;
        else return isOdd(n-1);
    }
}

