import java.util.*;

public class CountPairs {
    int[] parent;
    int[] size;
    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int[] edge : edges) {
            union(edge[0],edge[1]);
        }
        long all = ((long) n *(n-1))/2;
        long part = 0;
        boolean[] isRoot = new boolean[n];
        for (int i = 0; i < n; i++) {
            int root = find(i);
            if(!isRoot[root]){
                isRoot[root] = true;
                part += ((long) size[root] *(size[root]-1))/2;
            }
        }
        return all - part;
    }
    int find(int x){
        if (parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    void union(int x , int y){
        int findX = find(x);
        int findY = find(y);
        if(findY == findX) return;
        if(size[findX] >size[findY]) {
            parent[findY]= findX;
            size[findX] += size[findY];
        }else {
            parent[findX] = findY;
            size[findY] += size[findX];
        }
    }
    /*
    * 内存爆炸，利用并查集修改内存溢出问题
    * */
    /*public long countPairs(int n, int[][] edges) {
        if(edges.length == 0){
            return 0;
        }
        int[][] matrix = new int[n][n];
        boolean[] visited = new boolean[n];
        Arrays.fill(visited,false);
        for (int[] edge : edges) {
            matrix[edge[0]][edge[1]] = 1;
            matrix[edge[1]][edge[0]] = 1;
        }
        long count = 0;
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                stack.offerLast(i);
                dfs(visited,matrix,n,i);
                lists.add(new ArrayList<>(stack));
                while (!stack.isEmpty()){
                    stack.pollLast();
                }
                count++;
            }
        }
        long sum = 0;
        for (int i = 0; i < lists.size(); i++) {
            for (int j = i+1; j <lists.size(); j++) {
                sum+= (long) lists.get(i).size() *lists.get(j).size();
            }
        }
        return count == 1 ? 0 : sum;
    }

    private void dfs(boolean[] visited, int[][] matrix, int n, int i) {
        visited[i] = true;
        for (int j = 0; j < n; j++) {
            if(matrix[i][j] == 1&&!visited[j]){
                stack.offerLast(j);
                dfs(visited,matrix,n,j);
            }
        }
    }*/
}
