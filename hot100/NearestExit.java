import java.util.ArrayDeque;

public class NearestExit {
    public int nearestExit(char[][] maze, int[] entrance) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        queue.offer(new int[]{entrance[0],entrance[1],0});
        maze[entrance[0]][entrance[1]] = '+';
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int r = poll[0];
                int c = poll[1];
                int num = poll[2];
                //当在边界的时候就返回最小步数
                if ((r == 0 || r == maze.length - 1 || c == 0 || c == maze[0].length - 1)
                        && !(r == entrance[0] && c == entrance[1])) {
                    return num;
                }
                for (int[] direction : directions) {
                    int nr = r+direction[0];
                    int nc = c +direction[1];
                     if(nr >= 0 && nr < maze.length && nc >= 0 && nc < maze[0].length
                             && maze[nr][nc] == '.'){
                        queue.offer(new int[]{nr,nc,num+1});
                        maze[nr][nc] = '+';
                    }
                }
            }
        }
        return -1;
    }
}
