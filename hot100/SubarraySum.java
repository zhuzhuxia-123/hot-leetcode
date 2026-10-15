import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashMap;

public class SubarraySum {

/*    public int subarraySum(int[] nums, int k) {
        //统计前缀和的个数
        int count=0;
        //利用sum来保存遍历元素子区间的和
        for(int i=0;i<nums.length;i++){
            int sum = 0;
            for(int j=i;j<nums.length;j++){
               sum += nums[j];
               if(sum == k){
                   count++;
               }
            }
        }
        return count;

    }*/

    public int subarraySum(int[] nums, int k) {
        //count计算累加数组中和为k的子数组的个数
        int count =0,pre=0;
        //哈希表记录前缀和pre出现的次数
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        hashmap.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre+=nums[i];
            if(hashmap.containsKey(pre-k)){
                count+=hashmap.get(pre-k);
            }
            hashmap.put(pre,hashmap.getOrDefault(hashmap.get(pre),0)+1);
        }
        return count;
    }
}
