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
    int sum = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return sum;
    }
    int[] dfs(TreeNode root) {
        if ( root == null ) return new int[2];
        int[] rc = new int[]{1,root.val};
        
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        
        rc[0] += left[0] + right[0];
        rc[1] += left[1] + right[1];
        
        sum += Math.abs(rc[0]-rc[1]);
        
        return rc;
        
        
    }
}