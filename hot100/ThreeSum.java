import java.util.*;
//15. 三数之和
public class ThreeSum {
    //核心思路：采用的是定一变二法，一个固定点，两个动点
    //定点遇到与前一个已经遍历过的元素则跳过
    //动点遍历全部含有定点满足条件的全部可能，遇到重复元素则跳过
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> tr_sums = new ArrayList<>();
        if(nums == null || nums.length<3){
            return tr_sums;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0;i<=n-3;i++){
            int left = i+1 ,right = n-1;
            //跳过已经与第一个元素匹配的满足条件的数组
            if(i>0 && nums[i]==nums[i-1]) continue;
            while(left<right){
                int target = nums[i] + nums[left] +nums[right];
                if(target == 0){
                    tr_sums.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left<right && nums[left]==nums[left+1]) left++;//跳过重复的
                    while (left<right&&nums[right]==nums[right-1]) right--;//跳过重复的
                    left++;
                    right--;
                }else if(target<0)left++;
                else right--;
            }
            if(nums[i]==nums[i+1]) break;
        }
        return tr_sums;
    }
}
