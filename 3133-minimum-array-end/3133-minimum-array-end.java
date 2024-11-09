class Solution {
    public long minEnd(int n, int x) {
        long rc = x;
        long i = 1;
        long j = 1;
        
        while ( j < n ) {
            if ( ( i & x ) == 0 ) {
                if ( ( j & (n-1) ) > 0 ) 
                    rc |= i;
                j = j << 1;      
            }
            i = i << 1;
        }
        
        return rc;
    }
}