class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer,List<Integer>> map = new HashMap();
        for (int i=0;i<n;i++)
            map.put(i,new ArrayList());
        
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        
        List<Integer> list = new ArrayList();
        Map<Integer,Integer> values = new HashMap();
        
        for (int i=0;i<n;i++) {
            if ( map.get(i).size() < 2 )
                list.add(i);
            values.put(i, map.get(i).size());    
        }
        
        while ( list.size() > 0 ) {
            if ( n <= 2 )
                return list;
            int size = list.size();
            for (int i=0;i<size;i++) {
                int node = list.remove(0);
                n--;
                for (int nei : map.get(node) )
                {
                    values.put(nei,values.get(nei)-1);
                    if ( values.get(nei) == 1 )
                        list.add(nei);
                }
            }
            
        }
        
        
        return list;
    }

}