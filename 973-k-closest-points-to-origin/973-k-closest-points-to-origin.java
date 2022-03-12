class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] rc = new int[k][2];
        
        Queue<int[]> queue = new PriorityQueue<>( (a,b) -> ( a[0]*a[0] + a[1]*a[1] ) - ( b[0]*b[0] + b[1]*b[1] ) );
        for (int[] p : points)
            queue.add(p);
        
        int i = 0;
        while ( i < k )
            rc[i++] = queue.poll();
        return rc;
        
    }
}