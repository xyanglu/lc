class Solution {
    int n;
    String s;
    int k;
    int m = (int) 1e9+7;
    int[] dp;
    public int numberOfArrays(String s, int k) {
        n = s.length();
        dp = new int[n];
        Arrays.fill(dp,-1);
        this.s = s;
        this.k = k;
        return count(0) ;
    }
    int count(int i) {
        if ( i == n ) return 1;
        if ( s.charAt(i) == '0' ) return 0;
        if ( dp[i] != -1  ) return dp[i];
        
        int total = 0;
        long cur = 0;
        int curI = i;
        while ( curI < n && cur <= k ) {
            cur*=10;
            cur += (int) s.charAt(curI)-'0';
            
            if ( cur <= k ) {
                total += count(curI+1)%m;
                total %= m;
            }
            else
                break;
            curI ++;
        }
        dp[i] = total;
        return dp[i];
        
    }
}