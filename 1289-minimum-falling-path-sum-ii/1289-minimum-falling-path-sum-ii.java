class Solution {
    public int minFallingPathSum(int[][] grid) {
        
        for (int i=1;i<grid.length;i++) {  
            
            int x = 0;
            int y = 0;
            for (int j=0;j<grid[i-1].length;j++)
                if ( grid[i-1][j] < grid[i-1][x] )
                    x = j;
            
            for (int j=0;j<grid[i-1].length;j++)
                if ( y==x || grid[i-1][j] < grid[i-1][y] && j != x )
                    y = j;
            
//             System.out.println(Arrays.toString(grid[i-1]));
//             System.out.println(grid[i-1][x]+" "+grid[i-1][y]);
            
            for (int j=0;j<grid[i].length;j++)
                if ( x != j ) 
                    grid[i][j] += grid[i-1][x];            
                else
                    grid[i][j] += grid[i-1][y];
            
        }
        
            int smallest = Integer.MAX_VALUE;
            for (int g : grid[grid.length-1])
                smallest = Math.min(smallest,g);
            return smallest;
    }
}