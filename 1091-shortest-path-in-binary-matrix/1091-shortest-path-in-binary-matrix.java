class Solution {
    
    int[][] dirs = new int[][]{ {-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1} };
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        Set<String> visited = new HashSet();
        int rc = 1;
        Queue<int[]> queue = new LinkedList();
        if ( grid[0][0] == 0 )
            queue.add( new int[]{0,0,rc});
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0;i<size;i++) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            if ( x < 0 || y < 0 || x == grid.length || y == grid[0].length || visited.contains(x+" "+y) || grid[x][y] == 1) continue;
            //System.out.println(x + " "+y);


                        if ( x == grid.length -1 && y == grid[0].length - 1 ) return poll[2];


            visited.add(x+" "+y);
            
            for (int[] d : dirs)
                queue.add( new int[]{x+d[0],y+d[1],rc+1});
            }
            rc++;
        }
        
        
        return -1;
    }
}