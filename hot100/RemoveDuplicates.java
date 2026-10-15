import java.util.Collection;
import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public String removeDuplicates(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : arr){
            if(!stack.isEmpty()&&stack.peek() == c){
                stack.pop();
                continue;
            }
            stack.add(c);
        }
        StringBuilder s1 = new StringBuilder();
        while(!stack.isEmpty()){
            s1.append(stack.pop());
        }
        return s1.reverse().toString();
    }
}
