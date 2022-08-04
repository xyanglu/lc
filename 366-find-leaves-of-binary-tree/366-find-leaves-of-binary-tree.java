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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        
        while ( root.val != 0 ) {
            List<Integer> l = new ArrayList();
            dfs(root,l);
            list.add(l);
        }
        
        return list;
    }
    void dfs(TreeNode root,List<Integer> l) {
        if ( root.left == null && root.right == null )
        {
            l.add(root.val);
            root.val = 0;
            return;
        }
        else if ( root.left != null && root.left.val == 0 && root.right != null && root.right.val == 0 )
        {
            l.add(root.val);
            root.val = 0;
            return;
        }
        else if ( root.left != null && root.left.val == 0 && root.right == null)
        {
            l.add(root.val);
            root.val = 0;
            return;
        }        else if ( root.left == null && root.right != null && root.right.val == 0 )
        {
            l.add(root.val);
            root.val = 0;
            return;
        }
        if ( root.left != null && root.left.val != 0 )
            dfs(root.left,l);
        if ( root.right != null  && root.right.val != 0 )
            dfs(root.right,l);
    }
}