class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i=0;i<dp.length;i++)
        Arrays.fill(dp[i],-1);
        return dfs(obstacleGrid,0,0);
    }
    int dfs(int[][] g, int i, int j) {
        if ( i < 0 || j < 0 || i == g.length || j == g[0].length ) return 0;
        if ( g[i][j] == 1 ) return 0;
        if ( dp[i][j] != -1 ) 
            return dp[i][j];
        if ( i == g.length - 1 && j == g[0].length - 1 ) {
            dp[i][j] = 1;
            return 1;
        }
        int val = dfs(g,i+1,j) + dfs(g,i,j+1);
        dp[i][j] = val;
        return val;
    }
}