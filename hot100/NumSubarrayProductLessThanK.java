public class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int right = 0,left = 0;
        int ans = 1;
        int count = 0;
        while (left < nums.length){
            //计算乘积
            ans =ans*nums[right];
            //ans<k 就累加计数
            if(ans<k){
                count++;
            }
            //右值针移动
            right++;
            //不满足条件，边界出错则更新数据，重置左右指针
            if(ans>=k || right == nums.length){
                ans = 1;
                left++;
                right = left;
            }
        }
        return count;
    }
}
