package backtracking;

public class MazeQ {
    // count number of paths in a maze.
    public static void main(String[] args){
        // maze with obstacles
        boolean[][] board = {{true, true, true},
                {true, false, true},
                {true, true, true}};
        pathObstacles("", 0, 0, board);
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
}
