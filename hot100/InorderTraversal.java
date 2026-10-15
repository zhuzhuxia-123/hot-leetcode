import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
         inOrder(root);
         return ans;
    }

    public void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            ans.add(root.val);
            inOrder(root.right);
        }
    }
}
