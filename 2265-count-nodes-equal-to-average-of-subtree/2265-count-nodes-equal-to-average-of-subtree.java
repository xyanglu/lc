
class Solution {
    public int averageOfSubtree(TreeNode root) {
        int rc = 0;
        
        if ( root == null ) return 0;
        rc += total(root)/child(root) == root.val ? 1 : 0;
        rc+= averageOfSubtree(root.left) + averageOfSubtree(root.right);
        
        return rc;
    }
    int total(TreeNode root) {
        if ( root == null ) return 0;
        return root.val + total(root.left) + total(root.right);
    }
    int child(TreeNode root) { 
        if ( root == null )
            return 0;
        return 1 + child(root.left) + child(root.right);
    }
}