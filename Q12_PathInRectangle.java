package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/1/23 22:03
 */
public class Q12_PathInRectangle {
    /**
     * LeetCode 79
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) {
            return false;
        }
        if(word.length() == 0) {
            return true;
        }

        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        int[] pathLength = {0};
        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                if(backtrace(board,word,rows,cols,row,col,visited,pathLength)){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean backtrace(char[][] board,String word,int rows,int cols,int row,int col,boolean[][] visited,int[] pathLength){

        if(pathLength[0] == word.length()){
            return true;
        }

        boolean hasPath = false;

        if(row >= 0 && row < rows && col >= 0 && col < cols) {
            if(board[row][col] == word.charAt(pathLength[0]) && !visited[row][col]) {
                visited[row][col] = true;
                pathLength[0] = pathLength[0] + 1;


                hasPath = backtrace(board,word,rows,cols,row,col-1,visited,pathLength) ||
                        backtrace(board,word,rows,cols,row-1,col,visited,pathLength) ||
                        backtrace(board,word,rows,cols,row,col+1,visited,pathLength) ||
                        backtrace(board,word,rows,cols,row+1,col,visited,pathLength);

                if(!hasPath) {
                    visited[row][col] = false;
                    pathLength[0] = pathLength[0] - 1;
                }
            }
        }

        return hasPath;
    }
}
