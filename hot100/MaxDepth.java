public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root ==null){
            return 0;
        }
        int len_left = maxDepth(root.left);
        int len_right = maxDepth(root.right);
        return  len_right<len_left? len_left+1 : len_right+1;
    }
}
