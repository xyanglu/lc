class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int[] parent = new int[s.length()];
        for (int i=0;i<parent.length;i++)
            parent[i] = i;
        
        Map<Integer,Queue> map = new HashMap();
        for ( List<Integer> pair : pairs)
        {
            int p0 = pair.get(0);
            int p1 = pair.get(1);
            
            while ( parent[p0] != p0 )
                p0 = parent[p0];
            
            while ( parent[p1] != p1 )
                p1 = parent[p1];
            
            if ( p0 < p1 )
                parent[p1] = p0;
            else
                parent[p0] = p1;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=0;i<parent.length;i++) {
            int p = parent[i];
            while (p != parent[p])
                p = parent[p];
            if (!map.containsKey(p))
                map.put(p, new PriorityQueue<Character>((a,b)->a-b));
            map.get(p).add(s.charAt(i));
        }
        
        for (int i=0;i<parent.length;i++)
        {
            int p = parent[i];
            while ( p != parent[p] )
                p = parent[p];
            sb.append( map.get(p).poll() );
        }
        
        return sb.toString();
        
    }
}