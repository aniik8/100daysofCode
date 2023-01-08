public class Recursionmid4 {
    public static void main(String[] args) {
        //1. skipping a character from a string
        System.out.println(skipaChar("baccad", 'a', 0));
        //2. writing different substring of a given string
        substring("abc", "");
        // 3. permutation of a string using recursion
        permutataionString("abc", "");
        // 4. Addition of two using recursion
        slow_addition(13, 21);
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


}
