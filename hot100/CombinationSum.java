import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> arr = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int num =0;
        int startIndex = 0;
        backTracking(candidates,target,num,startIndex);
        return arr;
    }

    private void backTracking(int[] candidates, int target, int num,int startIndex) {
        if(num>target){
            return;
        }
        if(num == target){
            arr.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            backTracking(candidates,target,num+candidates[i],i);
            path.remove(path.size()-1);
        }
    }


}
