class Solution {
    int max = 0;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[nums.length+2];
        for (int i=0;i<arr.length;i++) {
            if ( i == 0 || i == arr.length - 1)
                arr[i] = 1;
            else
                arr[i] = nums[i-1];
        }

        int[][] dp = new int[n+1][n+1];
        
        dfs(1,n,dp,arr);
        
        return dp[1][n];
    }
    int dfs(int l, int r, int[][] dp, int[] arr) {
        if ( l > r )
            return 0;
        if ( dp[l][r] != 0 )
            return dp[l][r];
        
        for (int i=l;i<=r;i++)
        {
            int coins = arr[l-1] * arr[i] * arr[r+1];
            coins += dfs(l,i-1,dp,arr) + dfs(i+1,r,dp,arr);
            dp[l][r] = Math.max(dp[l][r],coins);
        }
        return dp[l][r];
    }
}