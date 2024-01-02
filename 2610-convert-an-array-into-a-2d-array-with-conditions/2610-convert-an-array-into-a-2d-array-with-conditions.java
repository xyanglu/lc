class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        Map<Integer,Integer> map = new HashMap();
        for (int n : nums)
            map.put(n,map.getOrDefault(n,0)+1);
        
        while ( map.size() > 0 ) {
            Map<Integer,Integer> clone = new HashMap(map);
            List<Integer> l = new ArrayList();
            for ( int key : map.keySet() ) {
                l.add(key);
                clone.put(key,clone.get(key)-1);
                if ( clone.get(key) == 0 ) 
                    clone.remove(key);
            }
            list.add(l);
            map = clone;
            
            
        }
        
        
        
        return list;
    }
}