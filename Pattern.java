public class Pattern {
    public static void main(String[] args) {
// 1. Functions to print hollow triangle
        patternHollowTD(10);
// 2. Function to print hollow equilateral triangle.
        hollowEqui(10);
// 3. function to print pattern of alphabet
       alphabet_pattern(5);
// 4. Function to print pattern of numbers
        patternNum(8);
}

    static void patternHollowTD(int n) {
        for( int row = 0; row < n; row++){
            for(int col = n; col >row; col--){
                if(col == n || row == 0 || row - col == -1){
                    System.out.print(" * ");
                }else{
                    System.out.print("   ");
                }

            }
            System.out.println();
        }
    }
    static void hollowEqui(int n) {
        for(int i=0; i<=n; i++){

            for(int j=0; j<=n; j++){

                if( i + j <= n-1){
                    System.out.print(" ");
                }else if(i + j == n || i == n || j == n){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    static void alphabet_pattern(int n){
        for(int i = 0; i <=5; i++) {
            for(int j=0; j<=i;j++){
                System.out.print((char) ('A'+ j));
            }
            System.out.println();

        }
    }
    static void patternNum(int n){
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <=n ; col++) {
                if( row + col <= n-1){
                    System.out.print(" ");
                }else if( row + col == n || col == n){
                    System.out.print("1 ");

                }else if(col == n-1 || row + col == n+1){
                    System.out.print(row + " ");}
                else if( row + col > n+1){
                    System.out.print(" " + (factorial(Math.max( row, col))/( factorial( Math.min(row, col)) * factorial(Math.max(row, col) - Math.min(row,col))) ) + " ");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    static int factorial(int fact)
    {
        if (fact == 0)
            return 1;
        return fact * factorial(fact - 1);
    }

}
