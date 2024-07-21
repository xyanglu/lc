import java.util.*;

class Solution {
    int k;
    
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        this.k = k;
        int[][] rc = new int[k][k];
        
        List<Integer> rowOrder = topoSort(rowConditions);
        List<Integer> colOrder = topoSort(colConditions);
        
        if (rowOrder.size() != k || colOrder.size() != k)
            return new int[0][0]; // Return an empty matrix if a valid topological sort is not possible
        
        int[] rowPos = new int[k + 1];
        int[] colPos = new int[k + 1];
        
        for (int i = 0; i < k; i++) {
            rowPos[rowOrder.get(i)] = i;
            colPos[colOrder.get(i)] = i;
        }
        
        for (int i = 1; i <= k; i++) {
            rc[rowPos[i]][colPos[i]] = i;
        }
        
        return rc;
    }
    
    List<Integer> topoSort(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[k + 1];
        
        for (int i = 1; i <= k; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);
            for (int neighbor : graph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        if (order.size() != k) {
            return new ArrayList<>(); // Return empty list if topological sort is not possible
        }
        
        return order;
    }
}
