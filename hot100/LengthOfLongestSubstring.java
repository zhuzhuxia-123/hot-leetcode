import java.util.HashSet;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }else if(s.length()==1){
            return 1;
        }
        char[] arr = s.toCharArray();
        //双指针来找最长不含重复子串
        int left = 0, right = 1;
        //利用set集合判断该滑动区间内有无重复的元素
        HashSet<Character> set = new HashSet<>();
        set.add(arr[left]);
        int max_num = 1;
        while(right < arr.length){
            if(set.add(arr[right])){
                right++;
            }else {
                //不断更新最大字串
                max_num = Math.max(right -left,max_num);
                //移除已经找到的含左边元素前缀left
                set.remove(arr[left]);
                left++;
            }

        }
        return Math.max(right -left,max_num);
    }

}
