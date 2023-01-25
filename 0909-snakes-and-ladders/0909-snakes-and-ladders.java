class Solution {
            int n = 0;

    public int snakesAndLadders(int[][] board) {
        n = board.length;
    Collections.reverse(Arrays.asList(board));
        
        Queue<int[]> queue = new PriorityQueue<>( (a,b) -> a[1] - b[1]);
        queue.add(new int[]{1,0});
        Set<Integer> visited = new HashSet();
        
        while ( !queue.isEmpty() ) {
            int[] pop = queue.poll();
            int s = pop[0];
            int steps = pop[1];
            if ( visited.contains(s) ) continue;
                visited.add(s);
            
            for (int i=1;i<7;i++) 
            {
                int next = s+i;
                int[] xy = posToInt(next,board);
                int x = xy[0];
                int y = xy[1];
                // System.out.println(next);
                if ( board[x][y] != -1 )
                    next = board[x][y];
                if ( next == n*n ) return steps + 1 ;

                queue.add(new int[]{next,steps+1});
            }
            
        }
        return -1;
        
        
    }
    int[] posToInt(int s, int[][] board) {
         s = s - 1;
        int r = s / n;
        int c = s % n;
        if ( r % 2 == 1 )
            return new int[]{r,n-1-c};
        else
            return new int[]{r,c};
    }
    
}