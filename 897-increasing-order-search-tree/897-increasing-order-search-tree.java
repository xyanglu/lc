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
    List<TreeNode> list = new ArrayList();
    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        
        for (int i=0;i+1<list.size();i++) 
            list.get(i).right = list.get(i+1);
        
        return list.get(0);
    }
    void dfs(TreeNode root) {
        if ( root == null ) return;
        dfs(root.left);
        root.left = null;
        list.add(root);
        dfs(root.right);
    }
}