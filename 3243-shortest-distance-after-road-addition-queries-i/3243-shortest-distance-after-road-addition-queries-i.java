class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] rc = new int[queries.length];
        Arrays.fill(rc,n-1);      
        Map<Integer,Set<Integer>> map = new HashMap();
        for (int i=0;i<n;i++) {
            map.put(i, new HashSet());
            map.get(i).add(i+1);
        }
            
        for (int i=0;i<queries.length;i++) {
            int[] q = queries[i];
            map.get(q[0]).add(q[1]);
            
            Queue<int[]> queue = new PriorityQueue<>( (a,b) -> a[1] - b[1] );
            queue.add(new int[2]);
            Set<Integer> set = new HashSet();
            
            while ( !queue.isEmpty() ) {
                q = queue.poll();
                if ( set.contains(q[0])) continue;
                set.add(q[0]);
                if ( q[0] == n - 1 ) {
                    rc[i] = q[1];
                    break;
                }
                for (int neigh : map.get(q[0]) )
                    queue.add(new int[]{neigh,q[1]+1});
            }
            
        }
        
        
        return rc;
    }
}