import java.util.ArrayDeque;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
        }
        return root;
    }
}
