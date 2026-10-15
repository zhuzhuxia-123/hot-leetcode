import java.util.Arrays;

public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max,num);
        }
        if(sum%2!=0){
            return false;
        }
        int[] dp = new int[sum/2+1];
        Arrays.fill(dp,0);
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum/2; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[sum / 2] == sum / 2;
    }
}
