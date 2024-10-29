class Solution {
    public int maxMoves(int[][] grid) {
        int rc = 0;
        int n = grid.length;
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        
        for (int i=0;i<grid.length;i++)
            rc = Math.max(rc,dfs(grid,i,0,dp));
        
        return rc;
    }
    int dfs(int[][] grid, int i, int j, int[][] dp) {
        int rc = 0;
        int cur = 0;
        if ( dp[i][j]!=-1 ) return dp[i][j];
        
        for (int k=-1;k<2;k++)
            if ( i+k >= 0 && i+k < grid.length && j+1 < grid[i+k].length && grid[i][j] < grid[i+k][j+1] )
            {
                cur = 1 + dfs(grid,i+k,j+1,dp);
                rc = Math.max(cur,rc);
            }
        
        dp[i][j] = rc;
        return rc;
    }
    
}