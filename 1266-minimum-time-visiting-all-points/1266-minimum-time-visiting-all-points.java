class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int rc = 0;
        
        for (int i=1;i<points.length;i++) {
            rc += Math.max(Math.abs(points[i][1]-points[i-1][1]),Math.abs(points[i][0]-points[i-1][0]));
            
            
        }
        
        return rc;
    }
}