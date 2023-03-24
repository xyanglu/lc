class Solution {
    public int mySqrt(int x) {
        long l = 0, r = x;
        long prev = 1;
        while ( l <= r ) {
            long m = (l+r)/2;
            if ( m * m > x ) 
                r = m - 1;
            else {
                l = m + 1;
                prev = m;
            }
        }
        return (int) prev;
    }
}