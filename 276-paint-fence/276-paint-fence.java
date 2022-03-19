class Solution {
    public int numWays(int n, int k) {
        return n(n,k);
    }
    int n (int n, int k ) {
        if ( n == 1 ) return k;
        if ( n == 2 ) return k*k;

        int slow = k;
        int fast = k*k;
        
        for (int i=3;i<=n;i++) {
            int temp = fast;
            fast = (k-1) * (fast + slow);
            slow = temp;
        }
        
        return fast;
    }
}