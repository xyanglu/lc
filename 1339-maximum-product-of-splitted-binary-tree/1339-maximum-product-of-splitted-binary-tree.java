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
    long max = 0;
    long total = 0;
    public int maxProduct(TreeNode root) {
        
        
        add(root);
        total = root.val;
        
        dfs(root);
        return (int) (max % (1e9+7));
    }
    int add(TreeNode root) {
        if ( root == null ) return 0;
        root.val += add(root.left) + add(root.right);
        return root.val;
    }
    void dfs(TreeNode root) {
        if ( root == null ) return;
        if ( root.left != null )
            max = Math.max(max,root.left.val * (total-root.left.val));
        if ( root.right != null )
            max = Math.max(max,root.right.val * (total-root.right.val));
        dfs(root.left);
        dfs(root.right);
    }
}