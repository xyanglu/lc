class Solution {
            Map<Integer,Map<Character,List<Integer>>> map = new HashMap();
    Map<String,Integer> used = new HashMap();
int n = 0;
    public int findRotateSteps(String ring, String key) {
         n = ring.length();

        for( int i=0;i<ring.length();i++) {
            char c = ring.charAt(i);
            map.put(i, new HashMap<>());
            for (int j=0;j<ring.length();j++) {
                char d = ring.charAt(j);
                if ( !map.get(i).containsKey(d))
                    map.get(i).put(d,new ArrayList());
                
                map.get(i).get(d).add(j-i);
            }
        }
        
        return dfs(0,key,0);
    }
    int dfs(int i, String key, int prev) {
        if ( i == key.length() ) return 0;
        if ( used.containsKey(i+" "+prev)) return used.get(i+" "+prev);
        char c = key.charAt(i);
        
        int rc = Integer.MAX_VALUE;
        
        for ( int dist : map.get(prev).get(c) ) {
            int alt = n - Math.abs(dist);
            if ( alt < Math.abs(dist) ) {
                rc = Math.min( Math.abs(alt) + 1 + dfs(i+1,key,prev+dist), rc );
            }
            else
                rc = Math.min( Math.abs(dist) + 1 + dfs(i+1,key,prev+dist), rc );
            
        }
        
        used.put(i+" "+prev,rc);
        return rc;
        
        
    }
}