class Solution {   
    int[][] dirs = new int[][]{ {-1,0},{1,0},{0,-1},{0,1} };
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] rc = new int[n][m];
        for (int i=0;i<n;i++)
            Arrays.fill(rc[i],-1);
        
        Queue<int[]> queue = new PriorityQueue<>( (a,b)->a[2]-b[2]);
        
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < m; j++) 
                if ( mat[i][j] == 0 )
                    queue.add(new int[]{i,j,0});
        
        while ( !queue.isEmpty() ) {
            
            int size = queue.size();
            while ( size-- > 0 ) {
                int[] p = queue.poll();
            
                int x = p[0];
                int y = p[1];
                
                if ( x<0||y<0||x==mat.length||y==mat[0].length||rc[x][y] != -1 ) continue;
                rc[x][y] = p[2];
                
                for (int[] d : dirs) 
                    queue.add(new int[]{x+d[0],y+d[1],p[2]+1});
                
                
            }
            
        }

        
        return rc;
    }
}
