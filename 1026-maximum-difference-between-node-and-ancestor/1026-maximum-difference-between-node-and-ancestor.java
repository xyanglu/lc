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
    int dif = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return dif;
    }
    void dfs(TreeNode root, int min, int max) {
        if ( root == null ) return;
        
        if ( root.val - min > dif )
            dif = root.val - min;
        if ( max - root.val > dif )
            dif = max - root.val;
            
        dfs(root.left, Math.min(min,root.val),Math.max(root.val,max));
        dfs(root.right, Math.min(min,root.val),Math.max(root.val,max));
    }
}