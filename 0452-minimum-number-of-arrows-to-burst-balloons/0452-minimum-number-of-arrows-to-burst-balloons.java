class Solution {
    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points,(a,b)-> Long.compare(a[1], b[1]) );

        int rc = 0;
        long prev = Long.MIN_VALUE;
        
        for (int[] p : points)
        {
            if ( p[0] > prev )
            {
                rc++;
                prev = p[1];
            }
            //System.out.println(Arrays.toString(p)+" "+prev+" "+rc);
        }
        
        return rc;
    }
}