import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return ans;
    }
    public void preOrder(TreeNode root){
        if(root != null){
            ans.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
