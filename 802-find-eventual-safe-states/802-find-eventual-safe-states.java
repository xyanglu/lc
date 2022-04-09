class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Map<Integer,List<Integer>> map = new HashMap();
        for (int i=0;i<graph.length;i++) {
            if ( !map.containsKey(i) )
                map.put(i, new ArrayList());
            for (int g : graph[i])
                map.get(i).add(g);
        }
        
        List<Integer> list = new ArrayList();
        for (int i=0;i<graph.length;i++)
            if ( dfs(map,i, new HashSet()) )
                list.add(i);
        return list;
    }
    boolean dfs( Map<Integer,List<Integer>> map, int i, Set<Integer> visited) {
        if ( visited.contains(i) ) return false;
        if ( map.get(i).size() == 0 ) return true;
        
        visited.add(i);
        for (int neigh : map.get(i) )
            if ( !dfs(map,neigh,visited) )
                return false;
        
        visited.remove(i);
        map.put(i, new ArrayList());
        
        return true;
    }
}