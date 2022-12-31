class Solution {
    int rc = 0;
    int zero = 1;
    public int uniquePathsIII(int[][] grid) {
        int x = 0;
        int y = 0;
        
        for (int i=0;i<grid.length;i++)
            for (int j=0;j<grid[i].length;j++)
                if ( grid[i][j] == 1 ) {
                    x = i;
                    y = j;
                }        
                else if ( grid[i][j] == 0  )
                    zero++;
        
        dfs(x,y,grid);
        return rc;
    }
    void dfs(int i, int j, int[][] grid) {
        if ( i < 0 || j < 0 || i == grid.length || grid[i].length == j || grid[i][j] == 3 || grid[i][j] == -1) return;
        if ( grid[i][j] == 2 ) {
            if ( zero == 0 )
                rc++;
            return;
        }
        grid[i][j] = 3;
        zero--;
        
        dfs(i-1,j,grid);
        dfs(i+1,j,grid);
        dfs(i,j-1,grid);
        dfs(i,j+1,grid);
        
        grid[i][j] = 0;
        zero++;        
        
    }
}