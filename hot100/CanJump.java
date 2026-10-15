public class CanJump {
    // cover表示覆盖范围，只要覆盖范围大于数组的长度，返回true
    public boolean canJump(int[] nums) {
        int cover = 0;
        if(nums.length == 1){
            return true;
        }
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover,i+nums[i]);
            if(cover >= nums.length -1 ){
                return true;
            }
        }
        return false;
    }
}
