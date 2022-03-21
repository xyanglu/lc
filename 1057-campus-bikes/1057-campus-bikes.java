class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[][] arr = new int[workers.length*bikes.length][3];
        int index = 0;
        for (int i=0;i<workers.length;i++)
            for (int j=0;j<bikes.length;j++) {
                int[] w = workers[i];
                int[] b = bikes[j];
                int dist = Math.abs(w[0] - b[0]) + Math.abs(w[1]-b[1]);
                arr[index] = new int[]{dist,i,j};
                index++;
            }
        
        Arrays.sort(arr,(a,b) -> a[0] == b[0] ? a[1] == b[1] ? a[2] - b[2] : a[1] - b[1] : a[0] - b[0] );
        Set<Integer> bikeSeen = new HashSet();
        Set<Integer> workSeen = new HashSet();
        int i = 0;
        int j = 0;
        int[] rc = new int[workers.length];
        while ( i < workers.length ) {
            int[] entry = arr[j++];
            if ( workSeen.contains(entry[1]) ) continue;
            if ( bikeSeen.contains(entry[2]) ) continue;
            workSeen.add(entry[1]);
            bikeSeen.add(entry[2]);
            rc[ entry[1] ] = entry[2]; 
            i++;
        }
        return rc;
        
    }
}