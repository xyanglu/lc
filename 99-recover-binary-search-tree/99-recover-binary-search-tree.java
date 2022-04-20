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
    
    Map<Integer,TreeNode> map = new HashMap();
    List<Integer> nums = new ArrayList();
    public void recoverTree(TreeNode root) {
        r(root);
        
    int x = -1, y = -1;
    boolean swapped_first_occurrence = false;
    for(int i = 0; i < nums.size() - 1; ++i) {
      if ( nums.get(i) > nums.get(i+1) ) {
        y = nums.get(i + 1);
        if (!swapped_first_occurrence) {
            // first swap occurrence
            x = nums.get(i);
            swapped_first_occurrence = true;
        } else {
            // second swap occurrence
            break;
        }
      }
    }
        
        recover(root, 2, x, y);

    }
      public void recover(TreeNode r, int count, int x, int y) {
    if (r != null) {
      if (r.val == x || r.val == y) {
        r.val = r.val == x ? y : x;
        if (--count == 0) return;
      }
      recover(r.left, count, x, y);
      recover(r.right, count, x, y);
    }
  }

    void r(TreeNode root) {
        if ( root == null ) return;
        r(root.left);
        map.put(root.val,root);
        nums.add(root.val);
        r(root.right);
    }
}