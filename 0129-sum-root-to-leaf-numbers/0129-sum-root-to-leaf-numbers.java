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
    int rc = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return rc;
    }
    void dfs(TreeNode root, int sum ) {
        if ( root == null ) return;
        sum *= 10;
        sum += root.val;
        if ( root.left == null && root.right == null ) {
            //System.out.println(sum);
            rc += sum;
            return;
        }
        dfs(root.left,sum);
        dfs(root.right,sum);
    }
}