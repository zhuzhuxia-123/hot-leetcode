import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class MyStack {

    private  Queue<Integer> q1;
    private  Queue<Integer> q2;
    private  int top ;
    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }
    // q2 = [1] q1 = []
    // q2 = [] ,q1 = [1]
    // q2 = [2] q1 = [1]
    // q2 = [2,1] q1 = []
    // q2 = []  q1 = [2,1]
    public void push(int x) {
        q2.add(x);
        top = x;
        while(!q1.isEmpty()) {
            q2.add(q1.remove()) ;
        }
        Queue<Integer> temp = new ArrayDeque<>();
        temp = q2;
        q2 = q1;
        q1 = temp;
    }

    public int pop() {
        int num = q1.remove();
        if(!q1.isEmpty()){
            top = q1.peek();
        }
        return num;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
       return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */