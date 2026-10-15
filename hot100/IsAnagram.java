/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词。



示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false


提示:

        1 <= s.length, t.length <= 5 * 104
s 和 t 仅包含小写字母
*/

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        //统计26个字母的字母异位词频率
        int[] arr = new int[26];
        //将字符串化为数组
        char[] arr1 = s.toCharArray();
        for(char value : arr1){
            //统计s单词出现的频率
            arr[value - 'a']++;
        }
        //将字符串化为数组
        char[] arr2 = t.toCharArray();
        for(char value:arr2){
            //统计t中字母出现的频率
            arr[value - 'a']--;
        }
        //判断数组是否全为0
        for(int i :arr){
            //若不是则不为字母异位词，s与t则有字符不同
            if(i!=0){
                return false;
            }
        }
        //若是则为字母异位词
        return true;
    }
}
