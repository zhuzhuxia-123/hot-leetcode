import java.util.Arrays;

public class MinEatingSpeed {
    // 0,0,0,1,1,1,1,1
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max,pile);
        }
        int n= piles.length;
        int right = max;
        int left = 1;
        while (left<=right){
            int mid = (left+right)/2;
            if (!BadVersion(piles,h,mid)){
                if( mid == 1 || BadVersion(piles,h,mid-1)){
                    return mid;
                }
                right = mid-1;
            }else {
                left = mid +1;
            }
        }
        return -1;
    }

    private boolean BadVersion(int[] piles, int h, int mid) {

        int i=0;
        for (int pile : piles) {
             i = i+ pile / mid;
            if(pile%mid != 0){
                i++;
            }
        }
        return i>h;
    }
}
