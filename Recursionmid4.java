public class Recursionmid4 {
    public static void main(String[] args) {
        System.out.println(skipaChar("baccad", 'a', 0));
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


}
