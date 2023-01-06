class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int rc = 0;
        
        Queue<Integer> queue = new PriorityQueue();
        for (int c : costs)
            queue.add(c);
        
        while ( !queue.isEmpty() ) {
            int c = queue.poll();
            if ( c > coins ) return rc;
            coins -= c;
            rc++;
        }
        
        
        return rc;
    }
}