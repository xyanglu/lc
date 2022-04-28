class Solution {
    public int minimumEffortPath(int[][] heights) {
        int l = 0, r = 1000000;
        int prev = r;
        while ( l <= r ) {
            int m = (l+r)/2;
            if ( can(heights,m,0,0,new HashSet()) ) {
                r = m - 1;
                prev = m;
                //System.out.println(prev+" "+l+" "+r);
            }
            else
                l = m + 1;
        }
        return prev;
    }
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    boolean can(int[][] heights, int max, int x, int y, Set<String> visited) {
                
            if ( x == heights.length - 1 && y == heights[0].length - 1 ) return true;
        String poll = x + " "+y;
        if ( visited.contains(poll)) return false;
        visited.add(poll);
            for (int[] dir : dirs) {
                int i = x + dir[0];
                int j = y + dir[1];
                if ( i < 0 || j < 0 || i == heights.length || j == heights[0].length || visited.contains(i+" "+j)) continue;
                if ( Math.abs( heights[i][j] - heights[x][y]) <= max && can(heights,max,i,j,visited)) return true; 
            }
        
        return false;
    }
}