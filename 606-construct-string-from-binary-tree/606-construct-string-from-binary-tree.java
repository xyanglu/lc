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
        StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode root) {
        dfs(root);
        return sb.toString();
    }
    void dfs(TreeNode root) {
        if ( root == null ) return;
        sb.append(root.val);
        boolean left = root.left != null;
        boolean right = root.right != null;
        if ( !left )
        {
            if ( right) {
                sb.append("()(");
                dfs(root.right);
                sb.append(")");
            }
        }
        else if ( left ) {
            sb.append("(");
            dfs(root.left);
            sb.append(")");
            if ( right ) {
                sb.append("(");
                dfs(root.right);
                sb.append(")");
            }
        }
    }
}