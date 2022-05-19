class Solution {
    int max = 0;
    public int longestIncreasingPath(int[][] matrix) {
        
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        for (int i=0;i<matrix.length;i++)
            for (int j=0;j<matrix[i].length;j++)
                dfs(dp,matrix,i,j);
        
        return max;
    }
    int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    int dfs(int[][] dp, int[][] matrix, int i, int j) {
        if ( dp[i][j]!=0 ) return dp[i][j];
        int cur = 1;
        
        for ( int[] d : dirs)
        {
            int x = i + d[0];
            int y = j + d[1];
            if ( x < 0 || y < 0 || x == matrix.length || y == matrix[0].length || matrix[i][j] >= matrix[x][y] ) continue;
            cur = Math.max(cur,1+ dfs(dp,matrix,x,y));
        }

        dp[i][j]=cur;
        max = Math.max(max,cur);
        return cur;
        
    }
}