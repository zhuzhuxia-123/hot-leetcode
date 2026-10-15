public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int min_sun = Integer.MAX_VALUE;

        for(int right = 0 ;right<nums.length;right++){
            sum += nums[right];//一直加到大于或等于target
            while (sum>=target){
                min_sun  = Math.min(right-left+1,min_sun);//满足条件的最小数组的长度
                sum -= nums[left++];//缩小区间
            }
        }
        return min_sun == Integer.MAX_VALUE ? 0 :min_sun;
    }

}
