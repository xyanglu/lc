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
    List<List<Integer>> list = new ArrayList();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        dfs(root,true,0);
        return list;
    }
    void dfs(TreeNode root, boolean start, int level) {
        if ( root == null ) return;
        if ( level == list.size() )
            list.add(new ArrayList());
        if ( start )
            list.get(level).add(root.val);
        else
            list.get(level).add(0,root.val);
        dfs(root.left,!start,level+1);
        dfs(root.right,!start,level+1);
    }
}