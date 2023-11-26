class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int max = 0;
        
        for (int i=0;i<matrix[0].length;i++) {
            for (int j=1;j<matrix.length;j++)    
            {
                if ( matrix[j][i] == 0 ) continue;
                matrix[j][i] += matrix[j-1][i];
            }                
        }
        
        for (int i=0;i<matrix.length;i++) {
        
            Arrays.sort(matrix[i]);
            //System.out.println(Arrays.toString(matrix[i]));
            int j = matrix[i].length;
            int m = Integer.MAX_VALUE;
            
            while ( j - 1 >= 0 && matrix[i][j-1] > 0 ) {
                j--;
                m = Math.min(matrix[i][j],m);
                            max =  Math.max(max,(matrix[i].length-j)*m);

            }
            
        }
        
        
        return max;
    }
}