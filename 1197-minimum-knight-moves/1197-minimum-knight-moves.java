class Solution {
    
        private final int[][] DIRECTIONS = new int[][] {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    
    public int minKnightMoves(int x, int y) {
        int rc = 0;
        x = Math.abs(x);
        y = Math.abs(y);
        
        Queue<int[]> queue = new LinkedList();
        Set<String> set = new HashSet();
        queue.add(new int[]{0,0});
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i=0;i<size;i++) {
                int[] p = queue.poll();
                int X = p[0];
                int Y = p[1];
                if ( X == x&& Y == y ) return rc;
                //System.out.println(X+" "+Y);

                for (int[] d : DIRECTIONS) {
                    int newX = X + d[0];
                    int newY = Y + d[1];
                    if (!set.contains(newX + "," + newY) && newX >= -1 && newY >= -1) {
                        queue.add(new int[] {newX, newY});
                        set.add(newX + "," + newY);
                    }
                }
                
            }
            
            
            rc++;
        }
        
        
        return rc;
    }
}