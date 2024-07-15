/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;es
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
    public TreeNode createBinaryTree(int[][] descriptions) {
        int i = 0;
        
        Map<Integer,TreeNode> map = new HashMap();
        for (int[] d : descriptions) 
            map.put( d[1], new TreeNode(d[1]));
        
        TreeNode root = null;
        for (int[] d : descriptions) {
            if ( !map.containsKey(d[0]))
            {
                root = new TreeNode(d[0]);
                map.put(d[0],root);
            }
            if ( d[2] == 1 ) 
                map.get(d[0]).left = map.get(d[1]);
            else
                map.get(d[0]).right = map.get(d[1]);
        }
        
        return root;
    }
}