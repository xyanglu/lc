class Solution {
    public int minimumTime(int[][] grid) {
        if ( grid[0][1] > 1 && grid[1][0] > 1 ) return -1;
        
        Queue<int[]> queue = new PriorityQueue<>( (a,b) -> a[2] - b[2] );
        queue.add(new int[3]);
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int m = grid.length;
        int n = grid[0].length;
        
        Set<String> set = new HashSet();
        while ( !queue.isEmpty() ) {
            int[] q = queue.poll();
            if ( q[0] == m - 1 && q[1] == n - 1 ) return q[2] ;
            
            for (int[] d : dirs) {
                int x = d[0] + q[0];
                int y = d[1] + q[1];
                if ( x < 0 || y < 0 || x == m || y == n || set.contains(x+" "+y) ) continue;
                int wait = 0;
                if ( Math.abs(grid[x][y] - q[2]) % 2 == 0 )
                    wait++;
                int n_time = Math.max( grid[x][y] + wait,  q[2] + 1 );
                    queue.add(new int[]{x,y,n_time});
                    set.add(x+" "+y);

            }       
        }
        
        return -1;
    }
}