package interview;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0){
            return;
        }
        int j =0 ;
        for (int i = 0;i<m+n;i++){
            if(j >= nums2.length){
                break;
            }
            if (nums1[i] == 0) {
                nums1[i] = nums2[j];
                j++;
            }
        }
        Arrays.sort(nums1);
    }
}
