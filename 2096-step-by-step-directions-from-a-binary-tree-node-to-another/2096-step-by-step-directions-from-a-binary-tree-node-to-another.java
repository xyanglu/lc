import java.util.*;

class Solution {
    StringBuilder start = new StringBuilder();
    StringBuilder dest = new StringBuilder();
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        dfs(root, startValue, new StringBuilder(), true);
        dfs(root, destValue, new StringBuilder(), false);
        
        // Remove common prefix
        while (start.length() > 0 && dest.length() > 0 && start.charAt(0) == dest.charAt(0)) {
            start.deleteCharAt(0);
            dest.deleteCharAt(0);
        }
        
        // Replace 'L' and 'R' with 'U' in the remaining paths
        String startPath = start.toString();
        String destPath = dest.toString();
        
        startPath = startPath.replace('L', 'U');
        startPath = startPath.replace('R', 'U');
        
        return startPath + destPath;
    }
    
    void dfs(TreeNode root, int value, StringBuilder path, boolean isStart) {
        if (root == null) return;
                
        if (root.val == value) {
            if (isStart) {
                start = new StringBuilder(path);
            } else {
                dest = new StringBuilder(path);
            }
            return;
        }
        path.append("L");
        dfs(root.left, value, path, isStart);
        path.deleteCharAt(path.length()-1);
        
        path.append("R");
        dfs(root.right, value, path, isStart);
        path.deleteCharAt(path.length()-1);
        
    }
}
