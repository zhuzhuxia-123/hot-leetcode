public class Trap {
    //木桶原理：1个单位key能够存储水的最大容量是等于min(key左边最大高度，key右边最大高度)-自身高度
    // 0或负数则没有储水
    public int trap(int[] height) {
        int n = height.length;
        int left=0,right=n-1;
        int maxR=0,maxL=0;
        int ans = 0;
        while (left<right){
            maxL = Math.max(maxL,height[left]);//height[left]加入比大小原因是防止负数的情况
            maxR = Math.max(maxR,height[right]);
            if(height[left]<height[right]){
                    ans+=maxL-height[left];
                    left++;
            }else {
                ans+=maxR-height[right];
                right--;
            }
        }
        return ans;

    }
}
