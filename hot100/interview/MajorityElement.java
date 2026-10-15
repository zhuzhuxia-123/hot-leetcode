package interview;

import java.util.HashMap;

public class MajorityElement {
    /*public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = n/2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
            if(map.get(num)>count){
                return num;
            }
        }
        return 0;
    }*/
    // 由于多数>n/2超过一半，多数-少数>=1
    public int majorityElement(int[] nums) {
        int vote = 0;
        int n = 0;
        for (int num : nums) {
            if(vote == 0){
                n = num;
            }

            if(n == num){
                vote++;
            }else {
                vote--;
            }
        }
        return n;
    }
}
