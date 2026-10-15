import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class RemoveKdigits {
    //删除数字使整体数字最小，从左往右删，小的进栈，大的出栈，小的比栈顶元素小，出栈进栈
    public String removeKdigits(String num, int k) {
        char[] arr = num.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        // 贪心构建单调递增栈
        for (char c : arr) {
            // 还有删除次数 并且 栈不为空 并且 当前数字更小，弹出栈顶
            while (k > 0 && !stack.isEmpty() && c < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        // 如果还有剩余删除次数，从末尾截断
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // 拼接结果
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }

        // 去除前导零
        int start = 0;
        sb = sb.reverse();
        while (start < sb.length() && sb.charAt(start) == '0') {
            start++;
        }
        String res = sb.substring(start);

        // 空结果返回 "0"
        return res.isEmpty() ? "0" : res;
    }

}
