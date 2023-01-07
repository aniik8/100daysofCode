public class Recursionmid4 {
    public static void main(String[] args) {
        //1. skipping a character from a string
        System.out.println(skipaChar("baccad", 'a', 0));
        //2. writing different substring of a given string
        substring("abc", "");
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

}
