import java.util.HashMap;
import java.util.HashSet;
/*给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
示例 1：
输入：nums = [1,2,3,1]
输出：true
解释：
元素 1 在下标 0 和 3 出现。
示例 2：
输入：nums = [1,2,3,4]
输出：false
解释：
所有元素都不同。
示例 3：
输入：nums = [1,1,1,3,3,4,3,2,4,2]
输出：true
提示：

        1 <= nums.length <= 105
        -109 <= nums[i] <= 109*/
public class ContainsDuplicate {
    //版本1
/*    public boolean containsDuplicate(int[] nums) {
        //建立哈希标dp_nums
        HashMap<Integer, Integer> dp_nums = new HashMap<>(nums.length);
        for (int num : nums) {
            //dp_nums的key是nums[i]值，value为重复次数
            dp_nums.put(num, dp_nums.containsKey(num) ? dp_nums.get(num) + 1 : 1);
            //判断若value大于1则有重复元素返回true
            if (dp_nums.get(num) > 1) {
                return true;
            }

        }
        //若没有则返回false
        return false;
    }*/
    //版本2
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashset = new HashSet<>();
        //利用hashset特性，如果有重复元素add就会返回false，集合中不添加重复元素
        for(int num:nums){
            if(!hashset.add(num)) return true;

        }
        return false;
    }


}
