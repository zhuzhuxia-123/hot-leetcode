public class HasPathSum {
    private int flag=0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
         preOrder(root,0,targetSum);
        return flag == 1;
    }

    private void preOrder(TreeNode root,int num,int targetSum){
        if(root!=null){
            if(root.left==null&&root.right==null){
                if(targetSum == num + root.val){
                    flag =1;
                }
            }
            preOrder(root.left,num+root.val,targetSum);
            preOrder(root.right,num+root.val,targetSum);
        }

    }
}
