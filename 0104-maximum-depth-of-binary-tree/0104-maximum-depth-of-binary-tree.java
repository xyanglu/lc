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
    public int maxDepth(TreeNode root) {
        int max = 0;
        
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList();
        if ( root != null )
            queue.add(new Pair<>(root,1));
        
        while ( !queue.isEmpty() ) {
            Pair<TreeNode,Integer> p = queue.poll();
            max = Math.max(p.getValue(),max);
            
            if ( p.getKey().left != null )
                queue.add( new Pair<>(p.getKey().left,p.getValue()+1));
            
            if ( p.getKey().right != null )
                queue.add( new Pair<>(p.getKey().right,p.getValue()+1));
            
            
        }
        
        return max;
    }
}