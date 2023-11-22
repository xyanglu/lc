class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer,List<Integer>> map = new TreeMap();
        int len = 0;
        for (int i=0;i<nums.size();i++)
            for (int j=0;j<nums.get(i).size();j++)
            {
                if ( !map.containsKey(i+j) ) 
                    map.put(i+j,new ArrayList());
                map.get(i+j).add(0,nums.get(i).get(j));
                len++;
            }
            
        int j = 0;
        int[] rc = new int[len];
        for (int key : map.keySet()) {
            for (int v : map.get(key) )
                rc[j++] = v;
        }
        
        
        
        return rc;
    }
}