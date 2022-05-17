/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode rc = null;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
        dfs(original,cloned,target);
        
        
        return rc;
    }
    void dfs(TreeNode o, TreeNode c, TreeNode t) {
        if ( o == null ) return;
        if ( o == t) {
            rc = c;
            return;
        }
        dfs(o.left,c.left,t);
        dfs(o.right,c.right,t);
    }
}