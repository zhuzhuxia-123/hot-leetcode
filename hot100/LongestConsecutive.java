import java.lang.reflect.Array;
import java.util.*;

public class LongestConsecutive {

   /* public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int[] array = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(array);
        int len = 1;
        for (int i = 0; i < array.length; i++) {
            for(int j = i+1 ; j<array.length;j++){
                int big_len=1;
                for(int k = i ;k<j ;k++){
                    if(array[k+1]-array[k]==1){
                        big_len++;
                    }else break;
                }
                if(big_len>len){
                    len = big_len;
                }
            }
        }
        return len;
    }*/

    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int[] array = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(array);
        int len = 0;
        int temp = 1;
        for (int i = 1; i < array.length; i++) {
            if(array[i] == array[i-1]+1){
                //连续元素
                temp++;
            }else {
                //连续中断
                len = Math.max(len,temp);
                temp=1;
            }

        }
        return Math.max(len,temp);
    }
}
