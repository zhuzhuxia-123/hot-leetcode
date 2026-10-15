import java.util.Arrays;
import java.util.List;

public class CanVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        boolean[] visited = new boolean[size];
        Arrays.fill(visited,false);
        visited[0] = true;
        dfs(visited,rooms,0);
        for (boolean flag : visited) {
            if(!flag){
                return false;
            }
        }
        return true;
    }

    private void dfs(boolean[] visited, List<List<Integer>> rooms,int n) {
        for (Integer i : rooms.get(n)) {
            if(!visited[i]){
                visited[i] = true;
                dfs(visited,rooms,i);
            }
        }
    }
}
