class Solution {
    Set<Integer> visited = new HashSet();
    Map<Integer,Set<Integer>> arr = new HashMap<>();
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer,List<Integer>> map = new HashMap();
        for (int i=0;i<n;i++)
            map.put(i,new ArrayList());
        
        for (int[] e : edges)
            map.get(e[1]).add(e[0]);
        
        
        List<List<Integer>> list = new ArrayList();
        
        for (int i=0;i<n;i++) 
            dfs(i, map );
        
        for (int i=0;i<n;i++) 
            list.add(new ArrayList(arr.get(i)));
        
        return list;
        
        }
    Set<Integer> dfs(int i, Map<Integer,List<Integer>> map) {
        if ( visited.contains(i) ) return arr.get(i);
        visited.add(i);
        
        Set<Integer> set = new TreeSet(); 
        
        for (int n : map.get(i) ) {
            set.add(n);
            set.addAll(dfs(n,map));
        }
        
        arr.put(i, set);
        return set;
            
        
        
        
    }
}