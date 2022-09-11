class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        long max = 0;
        long sum = 0;
        
        int[][] arr = new int[speed.length][2];
        for (int i=0;i<speed.length;i++)
            arr[i] = new int[]{speed[i],efficiency[i]};
        Arrays.sort(arr,(a,b)-> b[1] - a[1]);
        
        Queue<Integer> queue = new PriorityQueue<>();
        
        for (int i=0;i<speed.length;i++) {
            sum += arr[i][0];
            queue.add(arr[i][0]);
            if ( queue.size() > k  )
                sum -= queue.poll();
            max = Math.max( max , sum * arr[i][1] );
        }
        return (int) (max  % (int) (1e9+7)) ;
    }
}