public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int rc = 0;
        while ( n != 0 ) {
            rc++;
            n = n&(n-1);
        }
        return rc;
    }
}