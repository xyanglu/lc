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
    Map<Integer,Map<Integer,List<Integer>>> map = new TreeMap();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        dfs(root,0,0);
        
        for ( Map<Integer,List<Integer>> m : map.values() )
        {
            list.add( new ArrayList());
            for ( List<Integer> l : m.values() ) {
                Collections.sort(l);
                list.get(list.size()-1).addAll(l);
            }
        }
        
        return list;
    }
    void dfs(TreeNode root, int x, int y) {
        if ( root == null ) return;
        
        if ( !map.containsKey(x) )
            map.put(x,new TreeMap());
        if ( !map.get(x).containsKey(y) )
            map.get(x).put(y, new ArrayList());

        map.get(x).get(y).add(root.val);
        
        dfs(root.left,x-1,y+1);
        dfs(root.right,x+1,y+1);
    }
}