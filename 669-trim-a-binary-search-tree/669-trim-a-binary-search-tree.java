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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if ( root == null ) return null;
        if ( root.val < low || root.val > high ) {
            TreeNode left = trimBST(root.left,low,high);
            if ( left != null )
                root = left;
            else
                root = trimBST(root.right,low,high);
        }
        
        if ( root!=null ) {
            root.left = trimBST(root.left,low,high);
            root.right = trimBST(root.right,low,high);
        }
        
        return root;
    }
}