class Solution {
    public void rotate(int[][] matrix) {
        int l =0, r = matrix.length - 1;
        while ( l < r ) { 
            for (int i=0;i<(r-l);i++)
            {
                int top = l, bottom = r;
                
                int temp = matrix[top][l+i];
                //bottom left into top left
                matrix[top][l+i] = matrix[bottom-i][l];
                
                //bottom right into bottom left
                matrix[bottom-i][l] = matrix[bottom][r-i];
                
                //top right into bottom right
                matrix[bottom][r-i] = matrix[top+i][r];
                
                
                //top left into top right
                matrix[top+i][r] = temp; 
                
                
            }
            
            l++;
            r--;
        }
    }
}