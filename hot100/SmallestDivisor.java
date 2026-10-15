public class SmallestDivisor {
    // 0,0,0,0,1,1,1,1,1,1
    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max,num);
        }
        int left =1,right = max;
        while (left<=right){
            int mid = (left+right)/2;
            if(mid == 1 ||!isDivided(nums,threshold,mid)){
                if(isDivided(nums,threshold,mid-1)){
                    return mid;
                }
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }

    private boolean isDivided(int[] nums, int threshold, int mid) {
        int i=0;
        for (int num : nums) {
            i = i+num/mid;
            if (num%mid != 0){
                i++;
            }
        }
        return i>threshold;
    }
}
