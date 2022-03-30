class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        List<List<Integer>> list = new ArrayList();
        for (int i=0;i<wall.size();i++) {
            int cur = 0;
            List<Integer> temp = new ArrayList();
            for (int j=0;j<wall.get(i).size()-1;j++)
            {
                cur += wall.get(i).get(j);
                temp.add(cur);
            }
            list.add(temp);
        }
        
        Map<Integer,Integer> map = new HashMap();
        for ( List<Integer> l : list )
            for (int i : l)
                map.put(i,map.getOrDefault(i,0)+1);
        
        int min = wall.size();
        
        for ( int key : map.keySet() )
            min = Math.min(min, wall.size() - map.get(key));
        
        return min;
        
    }
}