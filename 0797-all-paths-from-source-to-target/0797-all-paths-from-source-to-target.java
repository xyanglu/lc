class Solution {
    List<List<Integer>> list = new ArrayList();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    
        Map<Integer,List<Integer>> map = new HashMap();
        for (int i=0;i<graph.length;i++) {
            map.put(i,new ArrayList());
            for (int neigh : graph[i])
                map.get(i).add(neigh);
        }
        
        dfs(0,map,new ArrayList());
        
        
        return list;
    }
    void dfs(int i, Map<Integer,List<Integer>> map, List<Integer> temp) {
        temp.add(i);
        for (int neigh : map.get(i) )
            dfs(neigh,map,temp);
        if ( i == map.size() - 1 ) {
            list.add(new ArrayList(temp));
            temp.remove( temp.size() - 1 );
            return;
        }
        temp.remove( temp.size() - 1 );
    }
}