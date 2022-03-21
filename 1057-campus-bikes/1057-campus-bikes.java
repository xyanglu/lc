class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[][] table = new int[workers.length * bikes.length][3];
        int index = 0;
        for(int i = 0; i < workers.length; i++) {
            int[] worker = workers[i];
            for(int j = 0; j < bikes.length; j++) {
                int[] bike = bikes[j];
                int distance = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
                table[index] = new int[] {distance, i, j};
                index++;
            }
        }
        Arrays.sort(table, (a, b) -> {
            int compare = a[0] - b[0];
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return a[2] - b[2];
                } else {
                    return a[1] - b[1];
                }
            } else {
                return a[0] - b[0];
            }
        });
        int[] result = new int[workers.length];
        Arrays.fill(result, -1);
        index = 0;
        HashSet<Integer> bikeSet = new HashSet<Integer>();
        while (bikeSet.size() <  workers.length) {
            int[] current = table[index];
            index++;
            if (result[current[1]] != -1 || bikeSet.contains(current[2])) {
                continue;
            }
            result[current[1]] = current[2];
            bikeSet.add(current[2]);
        }
        return result;
    }
}