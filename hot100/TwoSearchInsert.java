public class TwoSearchInsert {
    public int searchInsert(int[] nums, int target) {
        int left = 0,right=nums.length-1;
        int mid = 0;
        while (right>=left){
            mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            if (nums[mid]>target){
                right = mid -1;
            }else {
                left = mid+1;
            }
        }
        return right+1;
    }
}
