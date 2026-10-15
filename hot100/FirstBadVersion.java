public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 1,right = n;
        int mid = 0;
        int ans = 1;
        while(left<= right){
            //防止溢出，如果使用（right+left）会直接导致int溢出
            mid = left + (right - left) / 2;
            //不断找到第一个badversion
            if(isBadVersion(mid)){
                ans = mid;
                right =mid -1;
            }else {
                left = mid+1;
            }
        }
        return ans;
    }
}
