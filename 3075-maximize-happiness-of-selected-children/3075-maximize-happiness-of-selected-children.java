class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long rc = 0;
        Queue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        for (int h : happiness)
            queue.add(h);
        
        while ( k-- > 0 ) {
            int rem = happiness.length - queue.size();
            rc += Math.max(0,queue.poll() - rem);
        }
        
        
        return rc;
    }
}