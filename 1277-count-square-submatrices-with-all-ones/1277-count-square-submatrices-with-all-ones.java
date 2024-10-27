class Solution {
    int m = 0, n = 0;
    int[][] grid = null;
    public int countSquares(int[][] matrix) {
        int rc = 0;
        
         m = matrix.length;
         n = matrix[0].length;
        grid = matrix;
        
        for (int k=1;k<=Math.min(n,m);k++) {
            for (int i=0;i+k<=m;i++)
                for (int j=0;j+k<=n;j++)
                    rc += dfs(i,j,k);
            
            
        }
        
        
        return rc;
    }
    int dfs(int i, int j, int k ) {
        for (int x=i;x<i+k;x++)
            for (int y=j;y<j+k;y++)
                if ( grid[x][y] == 0 ) return 0;
        return 1;
    }
}