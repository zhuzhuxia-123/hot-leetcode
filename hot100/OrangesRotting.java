import java.util.ArrayDeque;

public class OrangesRotting {
    // 多源BFS
    public int orangesRotting(int[][] grid) {
        if(grid == null||grid[0].length == 0){
            return 0;
        }
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int freah_num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    freah_num++;
                }
            }
        }
        if(freah_num == 0){
            return 0;
        }
        int minutes = 0;
        //定义上下左右四个方向
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty()&&freah_num>0){
            int num =queue.size();
            //遍历完num个就完成一层多源BFS
            for (int i = 0; i < num; i++) {
                int[] poll = queue.poll();
                int r = poll[0];
                int c = poll[1];
                for (int[] direction : directions) {
                    int nr = r + direction[0];
                    int nc = c + direction[1];
                    if(nr>=0&&nc>=0&&nr<grid.length&&nc<grid[0].length&&grid[nr][nc]==1){
                        queue.offer(new int[]{nr,nc});
                        grid[nr][nc] = 0;
                        freah_num--;
                    }
                }
            }
            minutes++;
        }
        return freah_num == 0?minutes:-1;
    }
}
