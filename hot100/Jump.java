import java.lang.reflect.Array;
import java.util.Arrays;

public class Jump {
    public int jump(int[] nums) {
        int cover = 0;
        int jump_num = 0;
        int end = 0;
        if(nums.length == 1){
            return 0;
        }
        for (int i = 0; i <  nums.length-1; i++) {
            cover = Math.max(cover,i+nums[i]);
            if(i == end){
                jump_num++;
                end =cover;
            }
        }
        return jump_num;
    }
}
