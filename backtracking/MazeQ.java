package backtracking;

public class MazeQ {
    // count number of paths in a maze.
    public static void main(String[] args){
        // maze with obstacles
        boolean[][] board = {{true, true, true},
                {true, false, true},
                {true, true, true}};
        pathObstacles("", 0, 0, board);
        allpathObstacles("", 0, 0, board);

    }
    static int count_maze(int row, int column){
        if(row == 1 || column == 1) return 1;
        else{
            return count_maze(row-1, column) + count_maze(row, column-1);
        }
    }
    static void maze_path(String p, int row, int column){
        if(row == 1 && column == 1){
            System.out.println(p);
            return;
        }
        if(row > 1){
            maze_path(p + 'D', row-1, column);
        }if(column > 1){
            maze_path(p + 'R', row, column-1);
        }
    }

    // Diagonal included..
    static void maze_path_diagonal(String p, int row, int column){
        if(row==1 && column == 1){
            System.out.println(p);
            return;
        }
        if(row > 1 && column > 1){
            maze_path(p + "D", row-1, column-1);
        }
        if(row > 1){
            maze_path(p + 'H', row-1, column);
        }if(column > 1){
            maze_path(p + 'V', row, column-1);
        }
    }
    // maze problem with obstacles
    static void pathObstacles(String p, int row, int column, boolean[][] maze){
        if((row == maze.length - 1) && (column == maze[0].length-1) ){
            System.out.println(p);
            return;
        }
        if(!maze[row][column]) return;
        if(row < maze.length-1) pathObstacles( p + 'R', row+1, column, maze);
        if(column < maze[0].length-1) pathObstacles( p + 'D', row, column+1, maze);

    }
    // all paths included using BackTracking
    static void allpathObstacles(String p, int row, int column, boolean[][] maze){
        if((row == maze.length - 1) && (column == maze[0].length-1) ){
            System.out.println(p);
            return;
        }

        if(!maze[row][column]) return;
        maze[row][column] = false;
        if(row < maze.length-1) allpathObstacles( p + 'R', row+1, column, maze);
        if(column < maze[0].length-1) allpathObstacles( p + 'D', row, column+1, maze);
        if(row > 0) allpathObstacles(p+'U', row-1, column, maze);
        if(column > 0) allpathObstacles(p+'L', row, column-1, maze);
        maze[row][column] = true;
    }
     // N Queen's problem
     /* A utility function to print solution */
     void printSolution(int board[][])
     {
         for (int i = 0; i < N; i++) {
             for (int j = 0; j < N; j++)
                 System.out.print(" " + board[i][j]
                         + " ");
             System.out.println();
         }
     }

    /* A utility function to check if a queen can
       be placed on board[row][col]. Note that this
       function is called when "col" queens are already
       placed in columns from 0 to col -1. So we need
       to check only left side for attacking queens */
    boolean isSafe(int board[][], int row, int col)
    {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    /* A recursive utility function to solve N
       Queen problem */
    boolean solveNQUtil(int board[][], int col)
    {
        /* base case: If all queens are placed
           then return true */
        if (col >= N)
            return true;

        /* Consider this column and try placing
           this queen in all rows one by one */
        for (int i = 0; i < N; i++) {
            /* Check if the queen can be placed on
               board[i][col] */
            if (isSafe(board, i, col)) {
                /* Place this queen in board[i][col] */
                board[i][col] = 1;

                /* recur to place rest of the queens */
                if (solveNQUtil(board, col + 1) == true)
                    return true;

                /* If placing queen in board[i][col]
                   doesn't lead to a solution then
                   remove queen from board[i][col] */
                board[i][col] = 0; // BACKTRACK
            }
        }

        /* If the queen can not be placed in any row in
           this column col, then return false */
        return false;
    }

    /* This function solves the N Queen problem using
       Backtracking.  It mainly uses solveNQUtil () to
       solve the problem. It returns false if queens
       cannot be placed, otherwise, return true and
       prints placement of queens in the form of 1s.
       Please note that there may be more than one
       solutions, this function prints one of the
       feasible solutions.*/
    boolean solveNQ()
    {
        int board[][] = { { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } };

        if (solveNQUtil(board, 0) == false) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }
}
