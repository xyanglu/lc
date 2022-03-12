/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> lp = new ArrayList();
        TreeNode cur = root;
        while ( cur != p ) {
            lp.add(cur);
            if ( find(cur.left,p) )
                cur = cur.left;
            else if ( find(cur.right,p) )
                cur = cur.right;
        }
        lp.add(cur);
        
                List<TreeNode> lq = new ArrayList();
         cur = root;
        while ( cur != q ) {
            lq.add(cur);
            if ( find(cur.left,q) )
                cur = cur.left;
            else if ( find(cur.right,q) )
                cur = cur.right;
        }
        lq.add(cur);
        
        int i = 0;
        TreeNode prev = null;;
        while ( i < Math.min(lp.size(),lq.size()) && lp.get(i) == lq.get(i) )
        {
            prev = lp.get(i);
            i++;
        }
        return prev;
        
    }
    boolean find(TreeNode node, TreeNode target) {
        if ( node == null ) return false;
        if ( node == target ) return true;
        return find(node.left,target) ||
        find(node.right,target);
    }
}