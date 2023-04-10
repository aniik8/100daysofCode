public class mutualRecursion {
    public static void main(String[] args) {
        System.out.println(isEven(8));

        // rabbit problem using mutual recursion
        System.out.print(baby_rabbit(4));
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
    // rabbit problem using mutual recursion
    static int adult_rabbit(int n){
        if(n == 1) return 0;
        else return adult_rabbit(n-1) + baby_rabbit(n-1);
    }

    static int baby_rabbit(int n) {
        if(n == 1) return 1;
        else return adult_rabbit(n-1);
    }
}

