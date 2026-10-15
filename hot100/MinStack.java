import java.util.*;

public class MinStack {
    private final List<Integer> ans;
    private  final List<Integer> min_ans;
    public MinStack() {
        ans = new ArrayList<>();
        min_ans =new ArrayList<>();
    }

    public void push(int value) {
        ans.add(value);
        //min_ans存储全局最小数，也是按照进栈的方式
        if(min_ans.isEmpty()||value<= min_ans.get(min_ans.size()-1)){
            min_ans.add(value);
        }
    }

    public void pop() {
        Integer value = ans.remove(ans.size() - 1);
        //辅助栈判断是否等于主栈顶的值
        if(Objects.equals(value, min_ans.get(min_ans.size() - 1))) {
            min_ans.remove(min_ans.size()-1);
        }
    }

    public int top() {
        return ans.get(ans.size()-1);
    }

    public int getMin() {
        return min_ans.get(min_ans.size()-1);
    }
}
