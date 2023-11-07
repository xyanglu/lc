class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int rc = 0;
        
        Queue<int[]> queue = new PriorityQueue<int[]>( (a,b) -> (1.0f*b[0])/a[0] >= (1.0f*b[1])/a[1] ? 1 : -1  );
        for (int i=0;i<dist.length;i++)
            queue.add(new int[]{speed[i],dist[i]});
        
        while ( !queue.isEmpty() ) {
            int p[] = queue.poll();
            // System.out.println(Arrays.toString(p));
            rc++;
            // System.out.println(Arrays.toString(queue.peek()));

            if ( !queue.isEmpty() && rc*queue.peek()[0]/queue.peek()[1]>=1 ) return rc;
        }
        
        
        return rc;
    }
}