public class LongestOnes {
    //核心：窗口 [left, right] 内 0 的数量 ≤ k，不断右扩右边界，超量则右移左边界收缩窗口，全程记录窗口最大长度。
    //k为窗口变化的依据
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int count = 0;
        int max_num = 0;
        for (int right = 0; right < nums.length; right++) {
            if(nums[right]==0){
                count++;
            }
            while(count>k){
                if(nums[left]==0){
                    count--;
                }
                left++;
            }
            //// 当前窗口一定合法，更新最大长度
            max_num = Math.max(right-left+1,max_num);
        }
        return max_num;
    }
    //学业任务    //工程中心任务   //自己额外的提升任务
}
