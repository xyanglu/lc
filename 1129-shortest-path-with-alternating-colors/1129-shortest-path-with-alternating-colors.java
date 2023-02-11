class Solution {
            int[] rc;
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        rc = new int[n];
        Map<Integer,Set<Integer>> red = new HashMap();
        Map<Integer,Set<Integer>> blue = new HashMap();
        
        for (int i=0;i<n;i++) {
            red.put(i,new HashSet());
            blue.put(i,new HashSet());
        }
        
        for (int[] r : redEdges)
            red.get(r[0]).add(r[1]);
        
        for (int[] r : blueEdges)
            blue.get(r[0]).add(r[1]);
        
        Arrays.fill(rc,-1);
            
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{0,0,-1});
        Set<String> set = new HashSet();
        
        while ( !queue.isEmpty() ) {
            int[] p = queue.poll();
            if ( rc[p[0]] == -1 )
                rc[p[0]] = p[1];
            
            if ( p[2] != 0 ) {
                for ( int r : red.get(p[0]) )
                    if ( !set.contains(r+""+0) )
                    {
                        set.add(r +""+0);
                        queue.add(new int[]{r,p[1]+1,0});
                    }
            }
                        
            if ( p[2] != 1 ) {
                for ( int r : blue.get(p[0]) )
                    if ( !set.contains(r+""+1) )
                    {
                        set.add(r +""+1);
                        queue.add(new int[]{r,p[1]+1,1});
                    }
            } 
            
            }
        
        return rc;
    }
}