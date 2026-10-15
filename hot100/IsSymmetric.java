import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;

public class IsSymmetric {
//    现在的中序遍历只存节点值，空节点不会存入集合，会丢失左右不对称的空节点信息（比如左子树为空、右有值，单纯存数值无法区分）。
//    改进思路：
//    遍历时空节点也存入标识（用 null 代表空节点）；
//    不能用中序！判断对称二叉树必须用「左根右 / 右根左」配对遍历（前序镜像遍历），单纯中序序列对称不代表树对称（有反例）；
//    全局集合 temp 会多次调用残留旧数据，必须每次判断前清空，最好改成局部变量消除成员变量副作用。
    /*private ArrayList<Integer> temp = new ArrayList<>();
    public boolean isSymmetric(TreeNode root) {
        if(root.left==null&&root.right==null){
            return true;
        }
        inOrder(root);
        for (int i = 0; i < temp.size() / 2; i++) {
            if(!Objects.equals(temp.get(i), temp.get(temp.size() - i - 1))){
                return false;
            }
        }
        return true;
    }

    public void inOrder(TreeNode root){
        if(root!=null) {
            inOrder(root.left);
            temp.add(root.val);
            inOrder(root.right);
        }
    }*/
//    方案 1：改造遍历，空节点存入 null（推荐，镜像前序）
//    核心逻辑：
//    左树：根 → 左 → 右
//    右树：根 → 右 → 左
//    空节点直接 add null，最后对比两个序列是否完全一致
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        preOrderLeft(root,leftList);
        preOrderRight(root,rightList);
        if(leftList.size()!=rightList.size()) return false;
        for (int i= 0;i<leftList.size();i++){
            if(!Objects.equals(leftList.get(i),rightList.get(i))){
                return false;
            }
        }
        return true;
    }
    private void preOrderLeft(TreeNode root , ArrayList<Integer> leftList){
        if(root == null){
            leftList.add(null);
            return;
        }
        leftList.add(root.val);
        preOrderLeft(root.left,leftList);
        preOrderLeft(root.right,leftList);
    }
    private void preOrderRight(TreeNode root , ArrayList<Integer> rightList){
        if(root == null){
            rightList.add(null);
            return;
        }
        rightList.add(root.val);
        preOrderRight(root.right,rightList);
        preOrderRight(root.left,rightList);
    }

    //最优解：递归遍历
    /*public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }*/


}
