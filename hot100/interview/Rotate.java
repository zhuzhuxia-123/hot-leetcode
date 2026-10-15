package interview;

import java.util.Arrays;

public class Rotate {
    /*public void rotate(int[] nums, int k) {
        int n =nums.length;
        int sum = k%n;
        int[] nums2 = new int[n];
        int index = 0;
        for (int i = n-sum; i < n; i++) {
            nums2[index] = nums[i];
            index++;
        }
        for (int i = 0;i<n-sum;i++){
            nums2[index] = nums[i];
            index++;
        }
        System.arraycopy(nums2, 0, nums, 0, n);
    }*/

    public void rotate(int[] nums, int k) {
        k= k%nums.length;
        helper(nums,0,nums.length - k-1);
        helper(nums,nums.length-k,nums.length-1);
        helper(nums,0,nums.length-1);

    }
    public void helper(int[] nums,int start,int end){
        while (start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
