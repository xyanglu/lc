class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0;
        int y = 0;
        int max = 0;
        Set<String> set = new HashSet();
        for(int[] o : obstacles)
            set.add(o[0]+" "+o[1]);
        
        int dir = 0;
        int[][] dirs = new int[][]{ {0,1},{1,0},{0,-1},{-1,0} };
        
        for (int c : commands) {
            if ( c == -2 ) {
                dir = ( dir - 1 );
                if ( dir < 0 )
                    dir += dirs.length;
            }
            else if ( c == -1 ) {
                dir = (dir + 1) % dirs.length;
            }
            else {
                while ( c-- > 0 && !set.contains((x+dirs[dir][0])+" "+(y+dirs[dir][1]))) {
                       x += dirs[dir][0];
                        y += dirs[dir][1];
                }   
            }
            // System.out.println(x+" "+y);
            if ( x*x + y*y > max )
                max = x*x + y*y;
        }
        return max;
    }
}