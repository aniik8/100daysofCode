package backtracking;

public class MazeQ {
    // count number of paths in a maze.
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
}
