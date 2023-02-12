class Solution {
    long rc = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        Map<Integer,Set<Integer>> map = new HashMap();
        for (int[] r : roads) {
            int a = r[0];
            int b = r[1];
            if ( !map.containsKey(a) ) 
                map.put(a,new HashSet());
            
            if ( !map.containsKey(b) ) 
                map.put(b,new HashSet());
            
            map.get(a).add(b);
            map.get(b).add(a);
            
            
        }
        
        dfs(0,-1,seats,map);
        
        
        return rc;
    }
    int dfs(int s, int prev, int seats, Map<Integer,Set<Integer>> map) {
        int i = 0;
        if ( !map.containsKey(s) ) return 1;
        
        for (int n : map.get(s) )
            if ( n != prev ) {
                int d = dfs(n,s,seats,map);
                i+=d;
                long val = (long) Math.ceil( ( (d*1f / seats)));
                //System.out.println(val);
                rc += val;
            }
            
        return i + 1;
    }
}