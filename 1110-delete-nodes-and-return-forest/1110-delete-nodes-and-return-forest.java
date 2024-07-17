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
            Set<TreeNode> list = new HashSet();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet();
        for (int t : to_delete)
            set.add(t);
        
        list.add(root);
        
        dfs(root,set);
        
        return new ArrayList(list);
    }
    TreeNode dfs(TreeNode root, Set<Integer> set ) {
        if ( root == null ) return null;
        TreeNode res = root;
        if ( set.contains(root.val) ) {
            res = null;
            list.remove(root);
            if ( root.left != null )
                list.add(root.left);
            if ( root.right != null )
                list.add(root.right);
        }
        root.left = dfs(root.left,set);
        root.right = dfs(root.right,set);
        return res;
        
    }
}