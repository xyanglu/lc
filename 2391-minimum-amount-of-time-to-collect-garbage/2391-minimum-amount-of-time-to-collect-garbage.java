class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        Map<Character,Integer> map = new HashMap();
        int[] max = new int[3];
        
        for ( int i=0;i<garbage.length;i++) {
            String g = garbage[i];
            for ( char c : g.toCharArray() )
            {
                map.put(c,map.getOrDefault(c,0)+1);
                if ( c == 'M' ) max[0] = i;
                if ( c == 'P' ) max[1] = i;
                if ( c == 'G' ) max[2] = i;
            }
        }
        
        int rc = 0;
        
        for (char c : map.keySet()) {
            rc += map.get(c);
            int m = 0;
            if ( c == 'M' ) m = max[0];
            if ( c == 'P' ) m = max[1];
            if ( c == 'G' ) m = max[2];
            for (int i=0;i<m;i++)
                rc += travel[i];
        }
        
        return rc;
        
    }
}