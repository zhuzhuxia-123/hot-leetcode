import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        ArrayDeque<TreeNode> node_deque = new ArrayDeque<>();
        node_deque.offer(root);
        while (!node_deque.isEmpty()){
            int size = node_deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = node_deque.poll();
                if(i == size-1){
                    ans.add(node.val);
                }
                if(node.left!=null){
                    node_deque.offer(node.left);
                }
                if (node.right!=null){
                    node_deque.offer(node.right);
                }
            }
        }
        return ans;
    }
}
