class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        Set<Integer> set = new HashSet();
        int rc = 0;
        
        Map<Integer,List<Integer>> map = new HashMap();
        Map<Integer,Integer> rank = new HashMap();

        for (int i=1;i<=n;i++) {
            map.put(i,new ArrayList());
            rank.put(i,0);
        }
            
        Queue<Integer> queue = new LinkedList();
        for (int[] r : relations) {
            map.get(r[0]).add(r[1]);
            rank.put(r[1],rank.get(r[1])+1);
        }
        
        for ( int key : map.keySet() )
            if ( rank.get(key) == 0 ) 
                queue.add(key);
        
        while ( !queue.isEmpty() ) {
            int size = queue.size();
            for (int i=0;i<size;i++) {
                int poll = queue.poll();
                set.add(poll);
                for (int neigh : map.get(poll) )
                {
                    rank.put(neigh,rank.get(neigh)-1);
                    if ( rank.get(neigh) == 0 ) 
                        queue.add(neigh);
                }
            }
            rc++;
        }
        
        return set.size() == n ? rc : -1;
    }
}