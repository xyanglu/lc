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
    String rc = "";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root,"");
        return rc;
    }
    void dfs(TreeNode root, String temp) {
        if ( root == null ) return;
        temp = (char) ('a'+root.val)+temp;
        if (root.left == null && root.right == null ) {
            if ( rc.equals("") || temp.compareTo(rc) < 0 )
                rc = temp;
            return;
        }
            
        dfs(root.left,temp);
        dfs(root.right,temp);
    }
}