class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        
        for ( int i=1;i<=n;i++) {
                            int min = -1;

            for ( int j=1;j*j<=i;j++) {
                if ( i-(j*j)>=0 && dp[i-(j*j)]!=-1) {
                    int temp = dp[i-(j*j)] + 1;
                    if ( min < 0 || temp < min )
                        min = temp;
                }
                dp[i] = min;
            }
        }
        
        for (int i=1;i<=n;i++)
            System.out.println(i+"\t"+dp[i]);
        return dp[n];
    }
}