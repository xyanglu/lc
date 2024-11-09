class Solution {
    public long minEnd(int n, int x) {
        long rc = x;
        
        while ( n-- > 1 ) {
            rc=(rc+1)|x;
        }
        
        return rc;
    }
}