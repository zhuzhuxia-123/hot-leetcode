import java.util.Stack;
//20. 有效的括号
public class IsValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        boolean flag = true;
        for (char value : arr) {
          if(value == '{'||value=='['||value=='('){
              stack.push(value);
          }else {
              char c = stack.isEmpty()?'!':stack.pop();
              if(!(c=='{'&&value=='}'|| c=='['&&value==']'||c=='('&&value==')')){
                  flag=false;
                  break;
              }
          }
        }
        if(!stack.isEmpty()){
            flag = false;
        }
        return flag;
    }
}
