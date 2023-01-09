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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        
        Queue<TreeNode> queue = new LinkedList();
        if ( root!=null)
        queue.add(root);
        
        while ( !queue.isEmpty() )
        {
            root = queue.poll();
                    Queue<TreeNode> newQueue = new LinkedList(queue);
            queue = new LinkedList();
            list.add(root.val);
            if ( root.left!=null)
                queue.add(root.left);
            if( root.right!=null)
                queue.add(root.right);
            queue.addAll(newQueue);
        }
        
        return list;
    }
}