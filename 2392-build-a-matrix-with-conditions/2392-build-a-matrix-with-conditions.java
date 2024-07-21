import java.util.*;

class Solution {
    int k = 0;
    
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        this.k = k;
        List<Integer> rowOrder = topologicalSort(rowConditions);
        List<Integer> colOrder = topologicalSort(colConditions);

        int[][] matrix = new int[k][k];
        if (rowOrder.size() != k || colOrder.size() != k) {
            return new int[0][0];
        }
        
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
    
    private List<Integer> topologicalSort(int[][] conditions) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[k + 1];
        
        for (int i = 1; i <= k; i++) {
            adjList.put(i, new ArrayList<>());
        }
        
        for (int[] condition : conditions) {
            adjList.get(condition[0]).add(condition[1]);
            inDegree[condition[1]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order.add(curr);
            
            for (int neighbor : adjList.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        if (order.size() == k) {
            return order;
        }
        
        return new ArrayList<>();
    }
}
