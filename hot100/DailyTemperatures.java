import java.util.*;

public class DailyTemperatures {
    /*public int[] dailyTemperatures(int[] temperatures) {
        int n= temperatures.length;
        int j=0;
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for(j=i+1;j<n;j++){
                if(temperatures[i]<temperatures[j]){
                    flag=true;
                    break;
                }
            }
            if(flag){
                arr.add(j-i);
            }else {
                arr.add(0);
            }
        }
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }*/
    /*[73,74,75,71,69,72,76,73]
    i=0
    i=1 74 [0(73)]
    i=2 75 [1(74)]
    i=3 71 [2(75)]
    i=4 69 [2(75),3(69)]*/
    public int[] dailyTemperatures(int[] temperatures) {
        //栈记录下标，若遍历到的元素大于栈顶元素，则出栈元素，否则入栈
        //下标来计算天数
        Stack<Integer> stack = new Stack<>();
        int length = temperatures.length;
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while(!stack.isEmpty()&&temperature>temperatures[stack.peek()]){
                Integer pre_index = stack.pop();
                ans[pre_index] = i-pre_index;
            }
            stack.push(i);
        }
        return ans;
    }
}
