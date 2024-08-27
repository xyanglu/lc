class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Create adjacency list representation of the graph
        List<List<Pair<Integer, Double>>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double prob = succProb[i];
            graph.get(u).add(new Pair<>(v, prob));
            graph.get(v).add(new Pair<>(u, prob));
        }
        
        // Initialize probability array and priority queue
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;
        PriorityQueue<Pair<Integer, Double>> pq = new PriorityQueue<>((a, b) -> Double.compare(b.getValue(), a.getValue()));
        pq.offer(new Pair<>(start, 1.0));
        
        // Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Pair<Integer, Double> curr = pq.poll();
            int node = curr.getKey();
            double prob = curr.getValue();
            
            if (node == end) {
                return prob;
            }
            
            if (prob < maxProb[node]) {
                continue;
            }
            
            for (Pair<Integer, Double> neighbor : graph.get(node)) {
                int nextNode = neighbor.getKey();
                double edgeProb = neighbor.getValue();
                double newProb = prob * edgeProb;
                
                if (newProb > maxProb[nextNode]) {
                    maxProb[nextNode] = newProb;
                    pq.offer(new Pair<>(nextNode, newProb));
                }
            }
        }
        
        return 0.0;
    }
}
