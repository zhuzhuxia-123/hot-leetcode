public class MaxProfit {
    public int maxProfit(int[] prices) {
        boolean flag = false;
        int n1 = 0;
        int sum =0;
        for (int i = 1; i < prices.length; i++) {
            if(!flag && prices[i-1]<prices[i]){
                n1 = prices[i-1];
                flag =true;
            }
             if (flag && prices[i-1]>=prices[i]) {
                sum+=prices[i-1] - n1;
                flag = false;
            }else if(flag && i == prices.length-1){
                sum += prices[i] - n1;
            }
        }
        return sum;
    }
}
