/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList();
        Queue<Node> queue = new LinkedList();
        if ( root != null )
            queue.add(root);
        
        while ( !queue.isEmpty() ) {
            List<Integer> temp = new ArrayList();
            int size = queue.size();
            for (int i=0;i<size;i++) {
                root = queue.poll();
                temp.add(root.val);
                for ( Node child : root.children )
                    queue.add(child);
            }
            
            
            list.add(temp);
        }
        
        
        return list;
    }
}