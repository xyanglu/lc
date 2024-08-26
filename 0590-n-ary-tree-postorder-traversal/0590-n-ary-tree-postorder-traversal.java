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
    List<Integer> list = new ArrayList();
    public List<Integer> postorder(Node root) {
        if ( root == null ) return list;
        dfs(root);
        return list;
    }
    void dfs(Node root) {
        for ( Node child : root.children )
            dfs(child);
        list.add(root.val);
    }
}