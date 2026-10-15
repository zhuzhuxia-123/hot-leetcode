import java.util.HashMap;

public class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        char[] arr = s.toCharArray();
        int right = 0;
        int left = 0;
        int max_count = 0;
        int max_len = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < arr.length) {
            max_count =0;
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            for (int value : map.values()) {
                //找到每个字母出现的最大次数
                max_count = Math.max(max_count, value);
            }
            //窗口长度
            int len = right - left+1;
            //窗口长度-最大次数，则是需要替换字母发个数，在合法区间内才比较最大值
            //不在合法区间内要减小区间范围
            if (len - max_count <= k) {
                max_len = Math.max(max_len, len);
            } else {
                map.put(arr[left], map.get(arr[left]) - 1);
                left++;
            }
            right++;
        }
        return max_len;
    }

}
