import java.util.HashMap;

public class TwoSum {
    //版本1
   /* public int[] twoSum(int[] nums, int target) {
        for(int i =0 ;i< nums.length-1;i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }*/
    //优化版本2
    public int[] twoSum(int[] nums, int target) {
        //创建哈希表key记录nums[i]的值，value为下标
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);
        for(int i=0;i<nums.length;i++){
            //计算target的补数
            int bunum = target - nums[i];
            //判断是否在hashmap中发现bunum的key值
            if(hashMap.containsKey(bunum)){
                //存在则返回下标结果
                return new int[]{hashMap.get(bunum),i};
            }
            //若不存在，则放入hashmap
            hashMap.put(nums[i],i);
        }
        return new int[0];
    }
}
