class Solution {
    int n = 0;
    int m = 0;
    public int minDays(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        
        Set<String> set = new HashSet<>();
        int count = 0;
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
                if ( grid[i][j]==1 && !set.contains(i+" "+j) )
                {
                    dfs(grid,i,j,set);
                    count++;
                }
        
        if ( count != 1 ) return 0;
        
        List<String> land = new ArrayList(set);
        for (String s : land) {
            int x = Integer.valueOf(s.split(" ")[0]);
            int y = Integer.valueOf(s.split(" ")[1]);
            set = new HashSet();
            count = 0;
            
            grid[x][y] = 0;
            
            for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
                if ( grid[i][j]==1 && !set.contains(i+" "+j) )
                {
                    dfs(grid,i,j,set);
                    count++;
                }
            if ( count != 1 )
                return 1;
            
                        grid[x][y] = 1;

        }
        
        
        return 2;        
    }
    void dfs(int[][] grid, int i, int j, Set<String> set) {
        if ( i < 0 || j < 0 || i == n || j == m || grid[i][j] == 0 || set.contains(i+" "+j) ) return;
        set.add(i+" "+j);
        dfs(grid,i-1,j,set);
        dfs(grid,i+1,j,set);
        dfs(grid,i,j-1,set);
        dfs(grid,i,j+1,set);
    }
}