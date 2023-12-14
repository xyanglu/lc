class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] dCol = new int[n][2];
        int[][] dRow = new int[m][2];
        
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
            {
                dCol[i][grid[i][j]]++;
                dRow[j][grid[i][j]]++;
            }
        
        int[][] rc = new int[n][m];
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++) 
                rc[i][j] = dCol[i][1] - dCol[i][0] + dRow[j][1] - dRow[j][0];
        
        return rc;
    }
}