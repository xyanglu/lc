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
    public int sumNumbers(TreeNode root) {
        return cur(root,"");
    }
    int cur(TreeNode root, String temp ) {
        if ( root == null ) return 0;
        int sum = 0;
        temp += (char) (root.val + '0');
        if ( root.left == null && root.right == null ) 
            return Integer.parseInt(temp);
        
        if ( root.left!=null)
            sum+=cur(root.left,temp);
        if ( root.right!=null)
            sum+=cur(root.right,temp);
        return sum;
    }
}