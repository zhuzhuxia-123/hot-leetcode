import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CombinationSum3 {
    HashMap<String, Integer> map = new HashMap<>();
    List<List<Integer>> arr = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {

        int startIndex = 1;
        backTracking(k, n, startIndex);
        return arr;
    }

    private void backTracking(int k, int n, int startIndex) {

        if(path.size() == k){
            String s = "";
            int num = 0;
            for (Integer i : path) {
                s = s + i +",";
                num+=i;
            }
            if (!map.containsKey(s) && num == n) {
                map.put(s, 1);
                arr.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i < 10; i++) {
            path.add(i);
            backTracking(k,n,i+1);
            path.remove(path.size()-1);
        }
    }
}
