/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if ( has(root) )
            return root;
        else
            return null;
    }
    boolean has(TreeNode root) {
        if ( root == null ) return false;
        boolean has = false;
        if ( root.val == 1 ) 
            has = true;
        boolean left = has(root.left);
        if ( !left )
            root.left = null;
        boolean right = has(root.right);
        if ( !right  )
            root.right = null;
        return has || left || right;
    }
}