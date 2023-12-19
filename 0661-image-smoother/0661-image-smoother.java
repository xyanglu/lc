class Solution {
    public int[][] imageSmoother(int[][] img) {
        int n = img.length;
        int m = img[0].length;
        int[][] rc = new int[n][m];
        
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++) {
                int count = 0;
                int val = 0;
                
                //top left
                if ( i > 0 && j > 0 )
                {
                    val += img[i-1][j-1];
                    count++;
                }
                //top
                if ( i > 0 ) {
                    val += img[i-1][j];
                    count++;
                }
                //top right
                if ( i > 0 && j + 1 < m)
                {
                    val += img[i-1][j+1];
                    count++;
                }
                //left
                if ( j > 0 ) {
                    val += img[i][j-1];
                    count++;
                }
                //bottom left
                if ( j > 0 && i + 1 < n) {
                    val += img[i+1][j-1];
                    count++;
                }
                
                //bottom
                if ( i + 1 < n ) {
                    val += img[i+1][j];
                    count++;
                }
                //bottom right
                if ( i + 1 < n && j + 1 < m ) {
                    val += img[i+1][j+1];
                    count++;
                }
                //right
                if ( j + 1 < m ) {
                    val += img[i][j+1];
                    count++;
                }
                
                count++;
                val += img[i][j];
                
                rc[i][j] = val / count;
                // System.out.println(i+" "+j+" "+val+" "+count);
            }
        
        return rc;
    }
}