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
    List<Integer> list = new ArrayList();
    public TreeNode balanceBST(TreeNode root) {
        dfs(root);
        Collections.sort(list);
        return dfs(0,list.size()-1);
    }
    void dfs(TreeNode root) {
        if ( root == null ) return;
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
    TreeNode dfs(int l, int r) {
        if ( l > r ) return null;
        int m = (l+r)/2;
        int val = list.get(m);
        TreeNode node = new TreeNode(val);
        node.left = dfs(l,m-1);
        node.right = dfs(m+1,r);
        return node;
    }
}