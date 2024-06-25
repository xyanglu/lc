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
    int val = 0;
    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }
    void dfs(TreeNode root) {
        if ( root == null ) return;
        dfs(root.right);
        int temp = root.val;
        root.val += val;
        val += temp;
        dfs(root.left);
    }
}