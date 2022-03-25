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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        Queue<Pair<Integer,TreeNode>> queue = new PriorityQueue<>( (a,b) -> a.getKey() == b.getKey() ? a.getValue().val - b.getValue().val : a.getKey() - b.getKey() );
        queue.add(new Pair<Integer,TreeNode>(0,root));
        
        Map<Integer,List<Integer>> map = new TreeMap();
        while ( !queue.isEmpty() ) {
            Queue<Pair<Integer,TreeNode>> newQueue = new PriorityQueue<>( (a,b) -> a.getKey() == b.getKey() ? a.getValue().val - b.getValue().val : a.getKey() - b.getKey() );
            while ( !queue.isEmpty() ) {
                Pair<Integer,TreeNode> p = queue.poll();
                int v = p.getKey();
                root = p.getValue();
                if ( !map.containsKey(v) )
                    map.put(v,new ArrayList());
                map.get(v).add(root.val);
                if ( root.left != null )
                    newQueue.add(new Pair<Integer,TreeNode>(v-1,root.left));
                if ( root.right != null )
                    newQueue.add(new Pair<Integer,TreeNode>(v+1,root.right));
            }
            queue = newQueue;
        }
        
        for ( List<Integer> l : map.values() ) 
            list.add(l);
        
        
        return list;
    }
}