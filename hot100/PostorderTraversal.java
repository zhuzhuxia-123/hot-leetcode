import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);
        return ans;
    }

    public void postOrder(TreeNode root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            ans.add(root.val);
        }
    }
}
