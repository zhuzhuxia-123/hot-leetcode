import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumEffortPath {
    private static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    //dist[m][n]存储起始点（0，0）到（i，j）的最小体力消耗最优值
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        // 每次在堆中去出最小的体力的经过该点的路径
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        dist[0][0] = 0;
        heap.offer(new int[]{0, 0, 0});
        while (!heap.isEmpty()) {
            int[] poll = heap.poll();
            int effort = poll[0];
            int x = poll[1];
            int y = poll[2];
            // 遍历到目的地则输出
            if (x == m - 1 && y == n - 1) {
                return effort;
            }
            //去除堆中旧路径，堆中不同路径经过相同点都可能在一个堆中
            if (effort > dist[x][y]) continue;
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    int newEffort = Math.max(effort , Math.abs(heights[x][y] - heights[nx][ny]));
                    // 若比dist[nx][ny]还优解则替换，并加入堆，堆中不同路径经过相同点都可能在一个堆中
                    if(newEffort < dist[nx][ny]){
                        dist[nx][ny] = newEffort;
                        heap.offer(new int[]{newEffort,nx,ny});
                    }
                }
            }
        }
        return dist[m-1][n-1];
    }
    //暴力解法
    /*private int min_num = Integer.MAX_VALUE;
    private boolean[][] visited;
    public int minimumEffortPath(int[][] heights) {
        if(heights.length == 1 &&heights[0].length == 1){
            return 0;
        }
        int num=0;
        visited = new boolean[heights.length][heights[0].length];
        dfs(heights,0,0,num);
        return min_num;
    }

    private void dfs(int[][] heights, int i, int j, int num) {
        if(i<0||j<0||i>=heights.length||j>=heights[0].length||visited[i][j]){
            return;
        }
        if(i == heights.length-1&&j==heights[0].length-1){
            min_num = Math.min(num,min_num);
        }
        visited[i][j] = true;
        dfs(heights,i+1,j,Math.max(num,i+1>=heights.length? num : Math.abs(heights[i][j]-heights[i+1][j])));
        dfs(heights,i,j+1,Math.max(num,j+1>=heights[0].length? num : Math.abs(heights[i][j]-heights[i][j+1])));
        dfs(heights,i-1,j,Math.max(num,i-1<0? num : Math.abs(heights[i][j]-heights[i-1][j])));
        dfs(heights,i,j-1,Math.max(num,j-1<0? num : Math.abs(heights[i][j]-heights[i][j-1])));

    }*/

    /*二、回答你关键问题：部分路径没入堆会不会漏掉最优解？
    绝对不会漏掉最优解，两个铁规则保证：
    小根堆贪心性质
    代价最小的路径永远最先出队，最优路径一定是第一个被弹出的；只要它弹出时合法，立刻打上visited锁死。
    最优路径一定在入堆的那一批里面
    只要存在一条代价更小的合法路径，在遍历过程中一定会被计算出来、执行heappush压入堆。
    那些根本没入堆的路径，要么：
    路径上某个点已经被visited锁定，遍历的时候直接continue跳过；
    本身代价就比已找到的最优解更大，属于劣解，入堆也只会被后续过滤。
    简单说：没入堆的路径，一定不可能是更优路径。*/
    /*// 上下左右四个方向
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        // visited[i][j]：该点是否已经弹出堆、确定了最优解
        boolean[][] visited = new boolean[rows][cols];

        // 小根堆：数组格式 [当前路径最大代价, x行, y列]，按代价升序
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

        // 起点入堆：(代价0，横坐标0，纵坐标0)
        heap.offer(new int[]{0, 0, 0});

        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int cost = cur[0];
            int x = cur[1];
            int y = cur[2];

            // 到达右下角终点，直接返回（Dijkstra保证第一次弹出就是最优）
            if (x == rows - 1 && y == cols - 1) {
                return cost;
            }

            // 该点已经找到最优解，跳过堆里残留的劣等路径
            if (visited[x][y]) {
                continue;
            }

            // 标记为已确定最优，永久不再处理
            visited[x][y] = true;

            // 遍历四个方向邻居
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                // 越界判断
                if (nx < 0 || nx >= rows || ny < 0 || ny >= cols) {
                    continue;
                }
                // 邻居已经锁定最优，不用入堆
                if (visited[nx][ny]) {
                    continue;
                }

                // 计算本条边高度差，新路径代价取历史最大值
                int edgeDiff = Math.abs(heights[x][y] - heights[nx][ny]);
                int newMaxCost = Math.max(cost, edgeDiff);

                // 直接入堆，出堆时靠visited过滤无效数据
                heap.offer(new int[]{newMaxCost, nx, ny});
            }
        }

        // 题目保证一定有路径到达终点，理论不会走到这里
        return -1;
    }*/



}
