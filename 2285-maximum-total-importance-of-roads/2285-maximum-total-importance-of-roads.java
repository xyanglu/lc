class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long rc = 0;
        
        Map<Integer,Integer> map = new HashMap();
        for (int[] r : roads)
        {
            map.put(r[0],map.getOrDefault(r[0],0)+1);
            map.put(r[1],map.getOrDefault(r[1],0)+1);
        }
        
        Queue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>( (a,b) -> b.getValue() - a.getValue() );
        queue.addAll(map.entrySet());
        
        Map<Integer,Integer> values = new HashMap();
        while ( !queue.isEmpty() )
            values.put( queue.poll().getKey(), n-- );
        
        
        for (int[] r : roads)
            rc += values.get(r[0]) + values.get(r[1]);
        
        return rc;
    }
}