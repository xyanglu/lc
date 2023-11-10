class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer,Set<Integer>> map = new HashMap();
        Set<Integer> set = new HashSet();
        int size = 0;
        int len = 0;
        for (int[] r : adjacentPairs)
        {
            if ( !map.containsKey(r[0]) ) map.put(r[0],new HashSet());
            if ( !map.containsKey(r[1]) ) map.put(r[1],new HashSet());
            map.get(r[0]).add(r[1]);
            map.get(r[1]).add(r[0]);
            set.add(r[0]);
            set.add(r[1]);
        }
        
        int[] rc = new int[set.size()];
        
        for (Map.Entry<Integer,Set<Integer>> entry : map.entrySet()) 
            if ( entry.getValue().size() == 1 )
            {
                len = entry.getKey();
                break;
            }
        
        dfs(map,0,rc, len,new HashSet());
        
        
        return rc;
        
        
            
        
    }
    void dfs(Map<Integer,Set<Integer>> map, int i, int[] rc, int len, Set<Integer> set) {
        rc[i++] = len;
        set.add(len);
        for (int neigh : map.get(len ) ) {
            if ( set.contains(neigh) ) continue;
            dfs(map,i,rc,neigh,set);
        }
        
        
    }
}