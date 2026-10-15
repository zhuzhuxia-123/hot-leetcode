import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
* 有向无环图里：
- 如果一个点有入边，说明存在别的点可以走到它 → 不用选它
- 如果一个点没有任何入边，没人能到达它 → 必须选它
所有入度为 0 的点就是唯一最小点集。
* */
public class FindSmallestSetOfVertices {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];
        Arrays.fill(indegree,0);
        for (List<Integer> edge : edges) {
            indegree[edge.get(1)]++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(indegree[i] == 0){
                ans.add(i);
            }
        }
        return ans;
    }
}
