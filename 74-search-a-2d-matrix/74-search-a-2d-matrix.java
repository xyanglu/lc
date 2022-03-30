class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix,target,0,0);
    }
    boolean search(int[][] m, int target, int i, int j ) {
        if ( i >= m.length || j >= m[i].length || i < 0 || j < 0 ) return false;
        if ( m[i][j] > target ) return false;
        if ( m[i][j] == target ) return true;
        if ( i + 1 < m.length && m[i+1][j] <= target )
            return search(m,target,i+1,j);
        else
            return search(m,target,i,j+1);
    }
}