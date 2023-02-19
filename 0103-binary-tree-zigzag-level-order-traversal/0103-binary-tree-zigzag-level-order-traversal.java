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
    List<List<Integer>> list = new ArrayList();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList();
        if ( root != null )
            queue.add(root);
        
        boolean even = true;
        while ( !queue.isEmpty() ) {
            int size = queue.size();
            List<Integer> temp = new ArrayList();
            for (int i=0;i<size;i++) {
                root = queue.poll();
                            if ( !even )
                temp.add(0,root.val);
                else
                    temp.add(root.val);
                if ( root.left != null )
                    queue.add(root.left);
                if ( root.right != null )
                    queue.add(root.right);
            }
            list.add(temp);
            even = !even;
        }
        
        
        return list;
    }
}