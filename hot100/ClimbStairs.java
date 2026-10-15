public class ClimbStairs {
    // 1阶有1种方法，2阶有两种方法，3阶是1阶和2阶再走一步
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n];
        dp[0] =1;
        dp[1] =2;
        for (int i=2;i<n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
}
