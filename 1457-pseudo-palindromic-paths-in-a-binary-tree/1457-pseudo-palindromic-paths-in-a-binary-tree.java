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
    int rc = 0;
    Map<Integer,Integer> map = new HashMap();
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root);
        return rc;
    }
    void dfs(TreeNode root) {
        if ( root == null ) 
            return;
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        if ( root.left == null && root.right == null ) 
        {
            //System.out.println(map);
            boolean odd = false;
            boolean success = true;
            for ( int val : map.values() )
                if ( val % 2 == 1 )
                {
                    if ( odd ) 
                        success = false;
                    if ( !odd ) 
                        odd = true;
                }
            if ( success )
                rc++;
        }
        dfs(root.left);
        dfs(root.right);
        map.put(root.val,map.get(root.val)-1);
    }
}