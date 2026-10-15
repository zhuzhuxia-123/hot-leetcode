import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            //算出当前层的结点数
            int num_node = q.size();
            //遍历当前层的结点
            for (int i = 0; i < num_node; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }

}
