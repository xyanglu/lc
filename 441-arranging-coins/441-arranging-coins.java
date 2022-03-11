class Solution {
    public int arrangeCoins(int n) {
        if ( n < 3 ) return 1;
        if ( n < 4 ) return 2;
        
        long lo = 2, hi = n/2; 
        while ( lo <= hi ) {
            long m = lo + (hi-lo)/2;
            long val = m * (m + 1)/2 ;
            if ( val > n )
                hi = m - 1;
            else if ( val == n ) return (int) m;
            else 
                lo = m + 1;
        }
        
        return (int) hi;
    }
}