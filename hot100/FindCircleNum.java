public class FindCircleNum {
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        int num = 0;
        boolean[] visited = new boolean[m];
        for (int i = 0; i < m; i++) {
            if(!visited[i]){
                dfs(visited,isConnected,i);
                num++;
            }
        }
        return num;
    }

    private void dfs(boolean[] visited, int[][] isConnected,int i) {
        visited[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if(isConnected[i][j] == 1 && !visited[j]){
                dfs(visited , isConnected , j);
            }
        }
    }
}
