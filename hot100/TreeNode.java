public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // 无参构造
    public TreeNode() {}

    // 单值构造
    public TreeNode(int val) {
        this.val = val;
    }

    // 全参构造
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}