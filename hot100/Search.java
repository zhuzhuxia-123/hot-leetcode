public class Search {
    //每次都能找到一边是有序的，在有序的那边进行二分查找
    public int search(int[] nums, int target) {
        int left = 0 ,right = nums.length-1;
        int index = -1;
        while (left<=right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[left] <= nums[mid]){
                if(nums[left]<=target&&target<nums[mid]){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return index;
    }
}
