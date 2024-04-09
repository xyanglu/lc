class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int rc = 0;

        for (int i=0;i<tickets.length;i++) {
            if ( i <= k )
                rc += Math.min(tickets[k],tickets[i]);
            else
                rc += Math.min(tickets[k]-1,tickets[i]);
        }
                
        return rc;
        
        
    }
}