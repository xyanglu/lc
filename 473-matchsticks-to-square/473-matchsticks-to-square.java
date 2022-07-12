class Solution {
    public boolean makesquare(int[] M) {
        int sum  = 0;
        for (int m : M)
            sum += m;
        if ( sum % 4 != 0 ) return false;
        int q = sum /4;
        int[] dp = new int[4];
        Arrays.fill(dp,q);
        Arrays.sort(M);
        for (int i=0;i<M.length/2;i++) {
            int temp = M[i];
            M[i] =  M[ M.length - i - 1 ] ;
            M[ M.length - i - 1 ] = temp;
        }
        
        return make(0,M,dp);
    }
    boolean make(int i, int[] m, int[] dp) {
        if ( i == m.length ) return dp[0] ==0 && dp[1] == 0 && dp[2] == 0 && dp[3] == 0;
        for (int j=0;j<4;j++)
        {
            if ( dp[j] >= m[i] ) {
                dp[j] -= m[i];
                if ( make(i+1,m,dp) )
                    return true;
                dp[j] += m[i];
            }
        }
        return false;
    }
}