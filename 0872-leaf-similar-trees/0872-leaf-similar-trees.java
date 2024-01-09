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
    List<Integer> list1 = new ArrayList();
    List<Integer> list2 = new ArrayList();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs(root1,list1,0);
        dfs(root2,list2,0);
        // System.out.println(list1);
        // System.out.println(list2);
        return list1.equals(list2);
    }
    void dfs(TreeNode root, List<Integer> list, int i) {
        if ( root == null ) return;
        if ( root.left == null && root.right == null ) {
            list.add(root.val);
            return;
        }
        dfs(root.left,list,i-1);
        dfs(root.right,list,i+1);
    }
}