class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] rc = new int[grid.length-2][grid.length-2];
        
        for (int i=0;i<grid.length-2;i++)
            for (int j=0;j<grid.length-2;j++) {
                int max = 0;
                for (int k=0;k<3;k++)
                    for (int l=0;l<3;l++)
                        max = Math.max(grid[i+k][j+l],max);
                rc[i][j] = max;
            }
        
        return rc;
    }
}