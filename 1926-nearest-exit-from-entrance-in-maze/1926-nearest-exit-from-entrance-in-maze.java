class Solution {
    int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int nearestExit(char[][] maze, int[] entrance) {
        int steps = 0;
        
        Queue<String> queue = new LinkedList();
        queue.add(entrance[0] + " "+entrance[1]);
        maze[entrance[0]][entrance[1]] = '+';
        while ( !queue.isEmpty() ) {
            int size = queue.size();
            for (int i=0;i<size;i++) {
                String s = queue.poll();
                int x = Integer.parseInt(s.split(" ")[0]);
                int y = Integer.parseInt(s.split(" ")[1]);
                if ( x != entrance[0] || y!= entrance[1] ) {
                    if ( x < 0 || y < 0 || x == maze.length || y == maze[0].length || maze[x][y] == '+' ) continue;
                    if ( x == 0 || y == 0 || x == maze.length - 1 || y == maze[0].length - 1 ) 
                        return steps;
                }
                maze[x][y] = '+';
                //System.out.println(x+" "+y+" "+steps);
                for (int[] d : dirs)
                {
                    int a = x + d[0];
                    int b = y + d[1];
                    queue.add(a+" "+b);
                }
            }
            steps++;
        }
        
        
        
        return -1;
    }
}