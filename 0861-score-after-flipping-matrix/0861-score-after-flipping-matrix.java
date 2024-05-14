class Solution {
    int max = 0;
    
    public int matrixScore(int[][] grid) {
        return dfs(grid);
    }
    int dfs(int[][] grid) {        
        
        for (int i=0;i<grid.length;i++) {
            if ( grid[i][0] == 1 ) continue;
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = 1 - grid[i][j];
            }
        }

        int n = grid.length;
        for (int j = 0; j < grid[0].length; j++) {
            int temp = 0;
            for (int i = 0; i < grid.length; i++) 
                temp+=grid[i][j];
            if ( temp > n - temp ) continue;
            for (int i = 0; i < grid.length; i++) 
                grid[i][j] = 1 - grid[i][j];            
        }
                int num = 0;
        for (int[] gr : grid)
        {
            int m = gr.length;
            for (int j=0;j<m;j++) 
                num += gr[j] << (m-1-j);
        }
        return num;
    }
}