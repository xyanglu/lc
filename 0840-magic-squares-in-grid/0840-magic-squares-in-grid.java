class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rc = 0;
        
        for (int i=0;i+2<grid.length;i++) {
            for (int j=0;j+2<grid[0].length;j++) {
                boolean succ = true;
                                boolean[] dup = new boolean[10];

                      for (int k=i;succ&k<i+3;k++) 
            for (int l=j;l<j+3;l++) 
            {
                if ( grid[k][l]>9 || dup[grid[k][l]] ) { 
                    succ = false;
                                                       break;
                                                       }
                dup[grid[k][l]] = true;
            }
                
                succ &= ( grid[i][j] + grid[i][j+1] + grid[i][j+2] ) == 15;
                succ &= ( grid[i+1][j] + grid[i+1][j+1] + grid[i+1][j+2] ) == 15;
                succ &= ( grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2] ) == 15;

                succ &= ( grid[i][j] + grid[i+1][j] + grid[i+2][j] ) == 15;
                succ &= ( grid[i][j+1] + grid[i+1][j+1] + grid[i+2][j+1] ) == 15;
                succ &= ( grid[i][j+2] + grid[i+1][j+2] + grid[i+2][j+2] ) == 15;

                succ &= grid[i+1][j+1] == 5;
                
                succ &= ( grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2] ) == 15;
                succ &= ( grid[i+2][j] + grid[i+1][j+1] + grid[i][j+2] ) == 15;
                
                rc += succ?1:0;
            }
            
            
        }
        
        
        
        return rc;
    }
}