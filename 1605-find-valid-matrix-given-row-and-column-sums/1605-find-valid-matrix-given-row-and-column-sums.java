class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] rc = new int[rowSum.length][colSum.length];
        for (int i=0;i<rc.length;i++) 
            rc[i][0] = rowSum[i];
        
        
        for (int j=0;j+1<colSum.length;j++) {
            double sum = 0;
            for (int i=0;i<rowSum.length;i++)
                sum += rc[i][j];
            double diff = sum - colSum[j];
            for (int i=0;i<rowSum.length;i++) {
                int val = Math.min((int)diff,rc[i][j]);
                rc[i][j+1] += val;
                rc[i][j] -= val;
                diff -= val;
            }

            
            
        }
        return rc;
        
        
        
        
    }
}