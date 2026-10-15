import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class PacificAtlantic {
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] heights;
    int m,n;
    public List<List<Integer>> pacificAtlantic(int[][] heights){
        this.heights = heights;
        m = heights.length;
        n =heights[0].length;
        List<List<Integer>> arr = new ArrayList<>();
        //找到雨水能流向太平洋的格子
        boolean[][] pacific = new boolean[m][n];
        //找到雨水能流向大西洋的格子
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i,0,pacific);
        }
        for (int j = 0;  j< n; j++) {
            dfs(0,j,pacific);
        }
        for (int i = 0 ; i<m;i++){
            dfs(i,n-1,atlantic);
        }
        for (int j = 0; j < n; j++) {
            dfs(m-1,j,atlantic);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(pacific[i][j]&&atlantic[i][j]){
                    arr.add(List.of(i,j));
                }
            }
        }
        return arr;
    }

    private void dfs(int i, int j, boolean[][] ocean) {
        if(ocean[i][j]){
            return;
        }
        ocean[i][j] = true;
        for (int[] dir : dirs) {
            int nr = i+dir[0];
            int nc = j +dir[1];
            if(nr>=0&&nc>=0&&nr<ocean.length&&nc<ocean[0].length&&heights[nr][nc]>=heights[i][j]){
                dfs(nr,nc,ocean);
            }

        }
    }
    //暴力解法
    /*public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> arr = new ArrayList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = heights.length;
        if (m == 0) return arr;
        int n = heights[0].length;

        // 遍历每一个起点(i,j)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 1. 每次起点单独定义flag，局部变量最安全
                boolean reachPacific = false;
                boolean reachAtlantic = false;
                // 2. 每次BFS新建队列，彻底避免残留，也可以clear()
                Queue<int[]> queue = new ArrayDeque<>();
                // 3. 必须加访问数组，防止重复入队死循环
                boolean[][] visited = new boolean[m][n];

                queue.offer(new int[]{i, j});
                visited[i][j] = true;

                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    int r = curr[0];
                    int c = curr[1];

                    // 当前点触达太平洋边界
                    if (r == 0 || c == 0) {
                        reachPacific = true;
                    }
                    // 当前点触达大西洋边界
                    if (r == m - 1 || c == n - 1) {
                        reachAtlantic = true;
                    }

                    // 四个方向扩散：水从高往低/等高流
                    for (int[] dir : directions) {
                        int nr = r + dir[0];
                        int nc = c + dir[1];
                        // 越界 + 未访问 + 可以往下流
                        if (nr >= 0 && nr < m && nc >= 0 && nc < n
                                && !visited[nr][nc]
                                && heights[r][c] >= heights[nr][nc]) {
                            visited[nr][nc] = true;
                            queue.offer(new int[]{nr, nc});
                        }
                    }
                }

                // 两个大洋都能到达，加入结果
                if (reachPacific && reachAtlantic) {
                    List<Integer> point = new ArrayList<>();
                    point.add(i);
                    point.add(j);
                    arr.add(point);
                }
            }
        }
        return arr;
    }*/

}
