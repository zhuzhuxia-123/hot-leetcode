public class Rob {
    // 将偷n个房间的最大金额转化偷前k个房间的最大金额，分为两种偷法，最后一个房间不偷和最后房间偷
    // dp[i] 表示偷前i个房间的最大金额数
    public static int rob(int[] nums){
        int n =nums.length;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] =nums[0];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1] ,dp[i-2]+nums[i-1]);
        }
        return dp[n-1];
    }
    /*public static int rob(int[] nums) {
        int n = nums.length;

        if (n==1){
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < n; i++) {
            int min = Integer.MIN_VALUE;
            for (int j = 0; j < i - 1; j++) {
                min = Math.max(min,nums[i]+dp[j]);
            }
            dp[i] = min;
        }

        return Math.max(dp[n-1],dp[n-2]);
    }*/

}
