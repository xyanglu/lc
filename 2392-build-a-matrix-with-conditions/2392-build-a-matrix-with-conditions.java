import java.util.*;

class Solution {
    int k = 0;
    
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        this.k = k;
        List<Integer> rowOrder = topologicalSortDFS(rowConditions);
        List<Integer> colOrder = topologicalSortDFS(colConditions);
        
        if (rowOrder.size() != k || colOrder.size() != k) {
            return new int[0][0]; // Return an empty matrix if there's a cycle
        }
        
        int[][] matrix = new int[k][k];
        int[] rowPos = new int[k + 1];
        int[] colPos = new int[k + 1];
        
        for (int i = 0; i < k; i++) {
            rowPos[rowOrder.get(i)] = i;
            colPos[colOrder.get(i)] = i;
        }
        
        for (int i = 1; i <= k; i++) {
            int row = rowPos[i];
            int col = colPos[i];
            matrix[row][col] = i;
        }
        
        return matrix;
    }
    
    private List<Integer> topologicalSortDFS(int[][] conditions) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 1; i <= k; i++) {
            adjList.put(i, new ArrayList<>());
        }
        
        for (int[] condition : conditions) {
            adjList.get(condition[0]).add(condition[1]);
        }
        
        List<Integer> order = new ArrayList<>();
        boolean[] visited = new boolean[k + 1];
        boolean[] onPath = new boolean[k + 1];
        for (int i = 1; i <= k; i++) {
            if (!dfs(i, adjList, visited, onPath, order)) {
                return new ArrayList<>(); // Return an empty list if there's a cycle
            }
        }
        
        Collections.reverse(order);
        return order;
    }
    
    private boolean dfs(int node, Map<Integer, List<Integer>> adjList, boolean[] visited, boolean[] onPath, List<Integer> order) {
        if (onPath[node]) {
            return false; // Detected a cycle
        }
        if (visited[node]) {
            return true;
        }
        
        visited[node] = true;
        onPath[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (!dfs(neighbor, adjList, visited, onPath, order)) {
                return false;
            }
        }
        onPath[node] = false;
        order.add(node);
        
        return true;
    }
    
}
