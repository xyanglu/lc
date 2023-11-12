import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        Set<Integer> visitedBuses = new HashSet<>();
        Set<Integer> visitedStops = new HashSet<>();

        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToBuses.computeIfAbsent(stop, x -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(stopToBuses.getOrDefault(source, Collections.emptyList()));

        int buses = 1;

        while (!queue.isEmpty()) {
            int stopsInQueue = queue.size();
            for (int i = 0; i < stopsInQueue; i++) {
                int currentBus = queue.poll();
                if (visitedBuses.contains(currentBus)) {
                    continue;
                }
                visitedBuses.add(currentBus);

                for (int stop : routes[currentBus]) {
                    if (visitedStops.contains(stop)) {
                        continue;
                    }
                    visitedStops.add(stop);

                    if (stop == target) {
                        return buses;
                    }

                    for (int nextBus : stopToBuses.getOrDefault(stop, Collections.emptyList())) {
                        if (!visitedBuses.contains(nextBus)) {
                            queue.offer(nextBus);
                        }
                    }
                }
            }
            buses++;
        }

        return -1; // No valid route found
    }
}
