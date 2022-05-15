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
    public int deepestLeavesSum(TreeNode root) {
            int rc = 0;

        Queue<TreeNode> queue = new LinkedList();
        if ( root!=null )
            queue.add(root);
        
        while ( !queue.isEmpty() ) {
            rc = 0;
            Queue<TreeNode> newQueue = new LinkedList();
            while ( !queue.isEmpty() ) {
                root = queue.poll();
                rc += root.val;
                if ( root.left != null )
                    newQueue.add(root.left);
                if ( root.right !=null )
                    newQueue.add(root.right);
            }
            queue = newQueue;
        }
        
        return rc;
    }

}