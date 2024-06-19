class Solution {
    public int minDays(int[] bloomDay, int M, int k) {
        int l = 10000, r = 1;
        for (int b : bloomDay) {
            l = Math.min(l,b);
            r = Math.max(r,b);
        }
        int ans = -1;
        while ( l <= r ) {
            int rc = 0;
            int i = 0;
            int m = (l+r)/2;
            int prev = 0;
            while ( i < bloomDay.length ) {
                while ( i < bloomDay.length && bloomDay[i] > m ) {
                    i++;
                    prev = 0;
                }
                if ( i < bloomDay.length ) {
                    prev++;
                    if ( prev == k ) {
                        rc++;
                        prev = 0;
                    }
                    i++;
                }
            }
            if ( rc >= M ) {
                ans = m;
                r = m - 1;
            }
            else 
                l = m + 1;
        }
        
        return ans;
    }
}