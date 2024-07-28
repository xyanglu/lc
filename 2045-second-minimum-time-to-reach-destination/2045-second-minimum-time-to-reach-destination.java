class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer,List<Integer>> map = new HashMap();
        for (int i=1;i<=n;i++)
            map.put(i, new ArrayList());
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        
        Queue<Integer> queue = new LinkedList();
        queue.add(1);
        int cur = 0;
        int res = -1;
        Map<Integer,List<Integer>> visit = new HashMap();
        for (int i=1;i<=n;i++)
            visit.put(i, new ArrayList());     
        
        while ( !queue.isEmpty() ) {
            int size = queue.size();
            for (int i=0;i<size;i++) {
                int node = queue.poll();
                if ( node == n ) {
                    if ( res != -1 )
                        return cur;
                    res = cur;
                }
                for ( int nei : map.get(node) ) {
                    if ( visit.get(nei).size() == 0 || ( visit.get(nei).size() == 1 && visit.get(nei).get(0) != cur ) ) {
                    queue.add(nei);
                        visit.get(nei).add(cur);
                    }
                }
            }
            if ( ( cur / change ) % 2 == 1 ) 
                cur += change - (cur%change);
                    cur += time;

        }
        return 1;
    }
}