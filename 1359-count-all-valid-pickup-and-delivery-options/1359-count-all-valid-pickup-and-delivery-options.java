class Solution {
    int m = 1000000007;
    long[][] memo;
    public int countOrders(int n) {
        memo = new long[n+1][n+1];
        count(n,n);
        return (int) memo[n][n];
    }
    long count(int p, int d) {
        if ( p == 0 && d == 0) return 1;
        if ( p < 0 || d < 0 || d < p ) return 0;
        if ( memo[p][d] != 0 ) return memo[p][d];
        long waysP = p * count(p-1,d);
       long waysD = (d - p) * count(p,d-1);
        memo[p][d] = ( waysP + waysD) % m;
        return memo[p][d];
    }
}