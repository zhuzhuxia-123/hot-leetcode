import java.util.Stack;

public class MyQueue {
    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();

    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        //只有当第二个栈没有元素才能将第一个栈的元素入栈，实现元素倒转出栈
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
       return stack2.pop();
    }

    public int peek() {
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}
