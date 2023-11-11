import java.util.*;

class Graph {
    Map<Integer, List<int[]>> graph;

    public Graph(int n, int[][] edges) {
        graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
    }

    public void addEdge(int[] edge) {
        graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
    }

    public int shortestPath(int start, int end) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.offer(new int[]{start, 0});

        Set<Integer> visited = new HashSet<>();

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currentNode = current[0];
            int currentCost = current[1];

            if (visited.contains(currentNode)) {
                continue;
            }

            visited.add(currentNode);

            if (currentNode == end) {
                return currentCost;
            }

            for (int[] neighbor : graph.get(currentNode)) {
                if (!visited.contains(neighbor[0])) {
                    minHeap.offer(new int[]{neighbor[0], currentCost + neighbor[1]});
                }
            }
        }

        return -1; // No path found
    }
}
