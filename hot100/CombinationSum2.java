import java.util.*;

public class CombinationSum2 {
    List<List<Integer>> ans = new ArrayList<>();
    Set<List<Integer>> set = new LinkedHashSet<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int startIndex = 0;
        int num = 0;
        backtracking(candidates,target,num,startIndex);
        ans = new ArrayList<>(set);
        return ans;
    }

    private void backtracking(int[] candidates, int target,int num, int startIndex) {
        if(num>target){
            return;
        }
        if(num == target){
            ArrayList<Integer> temp = new ArrayList<>(path);
            set.add(temp);
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtracking(candidates,target,num+candidates[i],i+1);
            path.remove(path.size()-1);
            while (i<candidates.length-1 && candidates[startIndex] == candidates[i+1]){
                i++;
            }
        }
    }
}
