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
    public String tree2str(TreeNode root) {
        if ( root == null) return "";
        String s = root.val+"("+tree2str(root.left)+")"+"("+tree2str(root.right)+")";
        while ( s.length() > 1 && s.substring(s.length()-2,s.length()).equals("()") ) 
                s = s.substring(0,s.length()-2);
        
        return s;
    }
}