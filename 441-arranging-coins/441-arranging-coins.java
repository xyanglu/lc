class Solution {
    public int arrangeCoins(int n) {
        int lo = 1, hi = n;
        int max = 0;
        
        while ( lo <= hi ) {
            int m = lo + (hi-lo)/2;
            if ( (int) m/2.0 * (m + 1)  > n )
                hi = m - 1;
            else {
                lo = m + 1;
                max = Math.max(m,max);
            }
        }
        
        return max;
    }
}