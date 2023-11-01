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
    int count = 0;
    int max = 0;
    Map<Integer,Integer> map = new HashMap();
    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] rc = new int[count];
        int i = 0;
        for (Map.Entry<Integer,Integer> e : map.entrySet() )
            if ( e.getValue() == max )
                rc[i++] = e.getKey();
        
        return rc;
        
        
    }
    void dfs(TreeNode root) {
        if ( root == null ) return;
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        if ( map.get(root.val) == max ) {
            count++;
        }
        else if ( map.get(root.val) > max ) {
            max = map.get(root.val);
            count = 1;
        }
        dfs(root.left);
        dfs(root.right);
    }
}