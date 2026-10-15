import java.util.ArrayDeque;

public class Solve {
    private int[][] visited;
    public void solve(char[][] board) {
        visited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O'&&(i == 0||j==0||i==board.length-1||j==board[0].length-1)){
                    dfs(board,i,j);
                    visited[i][j] =1;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O'&&visited[i][j]!=1){
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void dfs(char[][] board, int i, int j) {
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]=='X'||visited[i][j] == 1){
            return;
        }
        visited[i][j] =1;
        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);
    }

}
