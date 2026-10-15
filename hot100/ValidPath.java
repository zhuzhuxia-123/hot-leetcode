import com.sun.source.tree.ReturnTree;

public class ValidPath {
    int[] parents;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parents = new int[n];
        init(parents);
        for (int[] edge : edges) {
            union(edge[0],edge[1]);
        }
        return find(source) == find(destination);
    }

    void init(int[] parents){
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }
    int find (int x){
        if(x == parents[x]){
            return x;
        }else return parents[x] = find(parents[x]);
    }
    void union(int x ,int y){
        int findx = find(x);
        int findy = find(y);
        if(findx != findy){
            parents[findx] = findy;
        }
    }
}
