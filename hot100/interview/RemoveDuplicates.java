package interview;

import java.nio.file.attribute.FileStoreAttributeView;
import java.util.Arrays;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n<=2){
            return n;
        }
        int fast = 2;
        int slow = 2 ;
        while (fast < n){
            if(nums[slow -2] != nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
