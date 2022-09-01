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
    public int goodNodes(TreeNode root) {
        return good(root,root.val);
    }
    int good(TreeNode root, int v) {
        if ( root == null ) return 0;
        int max = Math.max(root.val,v);
        if ( root.val >= v )
            return 1 + good(root.left,max) + good(root.right,max);
        else
            return good(root.left,max) + good(root.right,max);
    }
}