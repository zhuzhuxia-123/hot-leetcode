public class FindMaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        double avg = 0;
        int left = 0 ;
        double max_avg = Integer.MIN_VALUE;
        //left和right维护k区间
        for(int right = 0;right<nums.length;right++){
            double temp = 0;
            avg+=nums[right];
            int len = right - left +1;
            if(len == k){
                if(avg<0){
                    temp = -Math.abs(avg)/k;
                }else temp = avg/k;
                max_avg = Math.max(max_avg,temp);//找出最大平均数
                avg -= nums[left];
                left++;
            }
        }
        return max_avg;
    }
}
