class Solution {
    public int minCostConnectPoints(int[][] points) {
        Map<Integer,Map<Integer,Integer>> map = new HashMap();
        for (int i=0;i<points.length;i++)
            map.put(i, new HashMap());
        
        for (int i=0;i<points.length;i++)
            for (int j=i+1;j<points.length;j++) {
                int val = Math.abs( points[i][0] - points[j][0] ) + Math.abs(points[i][1] - points[j][1]);
                map.get(i).put(j,val);
                map.get(j).put(i,val);
            }
        
        Queue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>( (a,b) -> a.getValue() - b.getValue() );
        queue.addAll( map.get(0).entrySet() );
        
        int rc = 0;
        Set<Integer> set = new HashSet();
        set.add(0);
        while ( set.size() != points.length ) {
            Map.Entry<Integer,Integer> entry = queue.poll();
            int to = entry.getKey();
            int value = entry.getValue();
            if ( set.contains(to) ) continue;
            rc += value;
            set.add(to);
            queue.addAll( map.get(to).entrySet());
        }
        return rc;
        
    }
}