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
    Map<Integer,List<Integer>> map = new HashMap();
    public int amountOfTime(TreeNode root, int start) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        
        while ( list.size() != 0 ) {
            List<TreeNode> temp = new ArrayList();
            for (TreeNode node : list ) {
                if ( !map.containsKey(node.val) )
                    map.put(node.val, new ArrayList());
                if ( node.left != null ) {
                    if ( !map.containsKey(node.left.val) )
                        map.put(node.left.val, new ArrayList());
                    map.get(node.val).add(node.left.val);
                    map.get(node.left.val).add(node.val);
                    temp.add(node.left);
                }
                if ( node.right != null ) {
                    if ( !map.containsKey(node.right.val) )
                        map.put(node.right.val, new ArrayList());
                    map.get(node.val).add(node.right.val);
                    map.get(node.right.val).add(node.val);
                    temp.add(node.right);
                }
            }
            list = temp;
        }
        
        int rc = -1;
        Set<Integer> set = new HashSet();
        List<Integer> l = new ArrayList<Integer>();
        l.add(start);
        
        while ( l.size() != 0 ) {
            List<Integer> temp = new ArrayList();
            for (int i=0;i<l.size();i++) {
                int val = l.get(i);
                set.add(val);
                for (int neigh : map.get(val) )
                    if ( !set.contains(neigh) )
                        temp.add(neigh);
            }
            l = temp;
            rc++;
        }
        
        
        return rc;
        
        
        
    }
}