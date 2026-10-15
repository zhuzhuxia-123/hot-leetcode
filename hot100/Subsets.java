import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> arr = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        int startIndex = 0;
        backTracking(nums,startIndex);
        return arr;
    }

    private void backTracking(int[] nums, int startIndex) {
        arr.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backTracking(nums,i+1);
            path.remove(path.size()-1);
        }
    }


}
