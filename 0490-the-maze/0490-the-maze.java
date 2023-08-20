class Solution {
    Set<String> set = new HashSet();
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return dfs(maze,start,destination);    
    }
    boolean dfs(int[][] maze, int[] start, int[] destination) {
        int x = start[0];
        int y = start[1];
        if ( set.contains(x+" "+y)) return false;
        if ( x == destination[0] && y == destination[1] ) return true;
        if ( x < 0 || y < 0 || x == maze.length || y == maze[0].length ) return false;
        set.add(x+" "+y);
        //System.out.println(Arrays.toString(start));
        
        //up
        int t1 = x;
        int t2 = y;
        while (t1-1>=0 && maze[t1-1][y] == 0 ) t1--;
        if ( dfs(maze,new int[]{t1,t2},destination) ) return true;
        
        //down
        t1 = x;
        t2 = y;
        while (t1+1<maze.length && maze[t1+1][y] == 0 ) t1++;
        if ( dfs(maze,new int[]{t1,t2},destination) ) return true;
        
        //left
        t1 = x;
        t2 = y;
        while (t2-1>=0 && maze[x][t2-1] == 0 ) t2--;
        if ( dfs(maze,new int[]{t1,t2},destination) ) return true;
        
        //right
        t1 = x;
        t2 = y;
        while (t2+1<maze[0].length && maze[x][t2+1] == 0 ) t2++;
        if ( dfs(maze,new int[]{t1,t2},destination) ) return true;
        
        return false;
        
    }
    
}