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
class BSTIterator {
    
    Stack<Integer> next = new Stack();
    Stack<Integer> prev = new Stack();

    public BSTIterator(TreeNode root) {
        dfs(root);
    }
    void dfs(TreeNode root) {
        if ( root == null ) return ;
        dfs(root.right);
        next.add(root.val);
        dfs(root.left);
    }
    
    public boolean hasNext() {
        return !next.isEmpty();
    }
    
    public int next() {
        prev.add(next.pop());
        return prev.peek();
        
    }
    
    public boolean hasPrev() {
        return prev.size() > 1;
    }
    
    public int prev() {
        next.add(prev.pop());
        return prev.peek();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */