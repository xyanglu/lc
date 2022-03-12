class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i=0;i<matrix.length;i++)
            if ( !is(matrix,i,0) )
                return false;
        
        for (int i=0;i<matrix[0].length;i++)
            if ( !is(matrix,0,i))
                return false;
        
        return true;
    }
    boolean is(int[][] m, int i, int j) {
        int x = i;
        int y = j;
        while ( x < m.length && y < m[i].length ) {
            if ( m[x][y] != m[i][j] ) return false;
            x++;
            y++;
        }
        return true;
    }
}