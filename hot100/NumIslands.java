public class NumIslands {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int n_hang = grid.length;
        int n_lie = grid[0].length;

        int num = 0;
        //遍历每个结点
        for (int i = 0; i < n_hang; i++) {
            for (int j = 0; j < n_lie; j++) {
                if(grid[i][j]=='1'){
                    num++;
                    dfs(grid,i,j);
                }
            }
        }
        return num;
    }

    //每个结点的上下左右都要遍历
    private void dfs(char[][] grid, int i, int j) {
        //遍历的临界区
        if(i<0||j<0||grid.length <= i||grid[0].length <= j||grid[i][j]=='0'){
            return;
        }
        grid[i][j] = '0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }

}
