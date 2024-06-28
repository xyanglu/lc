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
           rc += (long) queue.poll().getValue() * n--;
        

        return rc;
    }
}