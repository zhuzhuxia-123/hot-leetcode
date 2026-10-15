import java.util.ArrayList;
import java.util.List;

public class Combine {
    private final List<List<Integer>> arr = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        int startIndex  = 1;
        backTracking(n,k,startIndex);
        return arr;
    }
    // arr.add(path)只是添加引用的地址，path里的数据还在不断的变化
    private void backTracking(int n, int k, int startIndex) {
        if(path.size() == k){
            arr.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backTracking(n,k,i+1);
            path.remove(path.size()-1);
        }
    }
}
