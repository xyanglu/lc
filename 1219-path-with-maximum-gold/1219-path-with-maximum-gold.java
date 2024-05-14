class Solution {
    // Map<String,Integer> map = new HashMap();
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        int n = grid.length;
        int m = grid[0].length;
        
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
                max = Math.max(max,dfs(grid,i,j));
               
        return max;
    }
    int dfs(int[][] grid, int i, int j) {
        if ( i < 0 || j < 0 || grid.length == i || grid[0].length == j || grid[i][j] == 0  || grid[i][j] == -1 ) return 0;
        int val = grid[i][j];
        grid[i][j] = -1;
        int down = dfs(grid,i-1,j);
        int up = dfs(grid,i+1,j);
        int left = dfs(grid,i,j-1);
        int right = dfs(grid,i,j+1);
        grid[i][j] = val;
        
        val += Math.max(down,Math.max(up,Math.max(left,right)));
        
        return val;
    }
}