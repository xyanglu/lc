class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int rc = 0;
        Queue<int[]> queue = new LinkedList<>(  );
        for (int i=0;i<tickets.length;i++)
            queue.add(new int[]{i,tickets[i]});
        
        while ( !queue.isEmpty() ) {
            rc++;
            int[] p = queue.poll();
            if ( p[0] == k && p[1] == 1 ) return rc;
            if ( p[1] > 1 )
                queue.add(new int[]{p[0],p[1]-1});
        }
        return rc;
        
        
    }
}