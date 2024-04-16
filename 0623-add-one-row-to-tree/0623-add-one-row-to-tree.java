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
    int v = 0;
    int d = 0;
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        v = val;
        d = depth;
        if ( d == 1 ) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        dfs(root,1);
        return root;
    }
    void dfs(TreeNode root, int depth) {
        if ( root == null ) return;
        if ( depth + 1 == d ) {
            TreeNode left = new TreeNode(v);
            left.left = root.left;
            root.left = left;
            TreeNode right = new TreeNode(v);
            right.right = root.right;
            root.right = right;
        }
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
        
        
    }
}