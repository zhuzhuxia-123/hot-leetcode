import java.util.ArrayList;
import java.util.List;

public class Permute {
    List<List<Integer>> arr = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backTracking(nums);
        return arr;
    }

    private void backTracking(int[] nums) {
        if(path.size() == nums.length){
            arr.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!path.contains(nums[i])){
                path.add(i);
                backTracking(nums);
                path.remove(path.size()-1);
            }
        }
    }
}
