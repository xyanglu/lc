class Solution {
    public int[][] generateMatrix(int n) {
        if ( n == 1 ) return new int[][]{{1}};
        int[][] grid = new int[n][n];
        int i = 0, j = 0;
        int val = 1;
        while ( true ) {
            
            //right
            while ( j < n ) {
                if ( grid[i][j] != 0 ) break;
                grid[i][j++] = val++;
            }
            j--;
            i++;
                        
            //down
            while (i < n ) {
                                if ( grid[i][j] != 0 ) break;
                grid[i++][j] = val++;
            }
            i--;
            j--;
            
            //left
            while ( j >= 0 ) {
                                if ( grid[i][j] != 0 ) break;
                grid[i][j--] = val++;
            }
            j++;
            i--;
            
            //up
            while ( i >=0 ) {
                                if ( grid[i][j] != 0 ) break;
                grid[i--][j] = val++;
            }
            i++;
            j++;
            
            if ( grid[i][j] != 0 ) break;
        }
        return grid;
    }
}