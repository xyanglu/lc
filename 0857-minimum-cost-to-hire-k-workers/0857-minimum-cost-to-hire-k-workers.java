import java.util.*;

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double minCost = Double.MAX_VALUE;
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        List<int[]> workers = new ArrayList<>();

        for (int i = 0; i < quality.length; i++) {
            workers.add(new int[]{quality[i], wage[i]});
        }

        // Sort workers based on the ratio of wage to quality
        Collections.sort(workers, (a, b) -> Double.compare((double) a[1] / a[0], (double) b[1] / b[0]));

        int qualitySum = 0;
        for (int[] worker : workers) {
            qualitySum += worker[0];
            maxHeap.offer((double) worker[0]);

            if (maxHeap.size() > k) {
                qualitySum -= maxHeap.poll();
            }

            if (maxHeap.size() == k) {
                minCost = Math.min(minCost, (double) worker[1] / worker[0] * qualitySum);
            }
        }

        return minCost;
    }
}
