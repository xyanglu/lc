class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int rc = 0;
        
        Queue<Integer> queue = new PriorityQueue<>();
        
        for (int i=0;i<rocks.length;i++)
            queue.add( capacity[i] - rocks[i]);
        
        
        while ( !queue.isEmpty() && additionalRocks > 0 ) {
            int remain = queue.poll();
            if ( additionalRocks >= remain )
            {
                additionalRocks -= remain;
                rc++;
            }
            
            
        }
        
        
        return rc;
    }
}