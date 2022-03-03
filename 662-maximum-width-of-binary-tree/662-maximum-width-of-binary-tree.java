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
    
    int max = 0;
    List<Integer> start = new ArrayList();
    List<Integer> end = new ArrayList();
    
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root,1,0);
        return max;
    }
    void dfs(TreeNode root, int order, int level) {
        if ( root == null ) return;
        if ( start.size() == level )
        {
            start.add(order);
            end.add(order);
        }
        else
            end.set(level,order);
        max = Math.max(max, end.get(level) - start.get(level) + 1 );
        dfs(root.left,order*2,level+1);
        dfs(root.right,order*2+1,level+1);
    }
}