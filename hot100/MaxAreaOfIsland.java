public class MaxAreaOfIsland {
    private int num = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n_hang = grid.length;
        int n_lie = grid[0].length;
        int max_area = 0;
        for (int i = 0; i < n_hang; i++) {
            for (int j = 0; j < n_lie; j++) {
                if(grid[i][j] == 1){
                    dfs(grid,i,j);
                    max_area = Math.max(num,max_area);
                    num = 0;
                }
            }
        }
        return max_area;
    }

    private void dfs(int[][] grid, int i, int j) {
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0){
            return;
        }
        grid[i][j] = 0;
        num++;
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
