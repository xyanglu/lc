class Solution {
    public int minFallingPathSum(int[][] matrix) {
    int min = Integer.MAX_VALUE;
    
        for (int i=matrix.length-2;i>=0;i--) {
           for (int j=0;j<matrix[0].length;j++) {
               //j == 0
               if ( j == 0 ) 
                   matrix[i][j] += Math.min(matrix[i+1][j],matrix[i+1][j+1]);
               //j == end
               else if ( j == matrix[0].length - 1 )
                   matrix[i][j] += Math.min(matrix[i+1][j-1],matrix[i+1][j]);
               
               //else
                else
                    matrix[i][j] += Math.min(matrix[i+1][j-1],Math.min(matrix[i+1][j],matrix[i+1][j+1]));
           } 
        }
        
        
        
        for (int i=0;i<matrix[0].length;i++)
            min = Math.min(min,matrix[0][i]);
        return min;
    }
}