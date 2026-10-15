import java.util.HashSet;

public class MaxVowels {
    public int maxVowels(String s, int k) {
        int left = 0;
        char[] arr = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int count = 0;
        int max_count=0;
        for(int right = 0;right<arr.length;right++){
            if(set.contains(arr[right])){
                count++;
            }
            int len = right-left+1;
            if(len == k){
               max_count= Math.max(max_count,count);
               if(set.contains(arr[left])){
                   count--;
                   left++;
               }else left++;
            }
        }
        return max_count;
    }
}
