class Solution {
    public String[] findRelativeRanks(int[] score) {
        Queue<int[]> queue = new PriorityQueue<>( (a,b) -> b[1] - a[1] );
        for (int i=0;i<score.length;i++)
            queue.add(new int[]{i,score[i]});
        
        String[] rc = new String[score.length];
        int i = 0;
        while ( !queue.isEmpty() ) {
            int[] p = queue.poll();
            if ( i == 0 )
                rc[p[0]] = "Gold Medal";
            else if ( i == 1 )
                rc[p[0]] = "Silver Medal";
            else if ( i == 2 )
                rc[p[0]] = "Bronze Medal";
            else
                rc[p[0]] = String.valueOf(i+1);
            i++;
        }
        return rc;
        
    }
}