import java.util.*;

public class LowestCommonAncestor {
    //错误解法
    /*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> temp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        temp.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                // 左占位
                TreeNode left = node.left;
                temp.add(left);
                if (left != null) queue.offer(left);
                // 右占位
                TreeNode right = node.right;
                temp.add(right);
                if (right != null) queue.offer(right);
            }
        }

        int pi = temp.indexOf(p);
        int qi = temp.indexOf(q);
        while (pi != qi) {
            if (pi > qi) pi = (pi - 1) / 2;
            else qi = (qi - 1) / 2;
        }
        return temp.get(pi);
    }*/
    //保留父节点和子结点的值
    Map<Integer,TreeNode> parent = new HashMap<Integer,TreeNode>();
    Set<Integer> visited = new HashSet<>();
    public void dfs(TreeNode root){
        if(root.left!=null){
            parent.put(root.left.val,root);
            dfs(root.left);
        }
        if(root.right!=null){
            parent.put(root.right.val,root);
            dfs(root.right);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p!=null){
            visited.add(p.val);
            p=parent.get(p.val);
        }
        while (q!=null){
            if(visited.contains(q.val)){
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }
}
