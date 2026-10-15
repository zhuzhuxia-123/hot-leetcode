import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AllPathsSourceTarget {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Deque<Integer> stack = new ArrayDeque<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0);
        dfs(graph,0,graph.length-1);
        return ans;
    }

    private void dfs(int[][] graph, int x, int n) {

        if(x == n){
            ans.add(new ArrayList<>(stack));
        }

        for(int i : graph[x]){
            stack.offerLast(i);
            dfs(graph,i,n);
            stack.pollLast();
        }
    }
}
