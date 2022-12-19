class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer,List<Integer>> map = new HashMap();
        for (int i=0;i<n;i++)
            map.put(i,new ArrayList());
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        
        return dfs(map,new HashSet(),source,destination);
        
    }
    boolean dfs(Map<Integer,List<Integer>> map, Set<Integer> set, int s, int d) {
        if ( s == d ) return true;
        for (int neigh : map.get(s) ) {
            if ( set.contains(neigh ) ) continue;
            set.add(neigh);
            //System.out.println(neigh);
            if ( dfs(map,set,neigh,d) )
                return true;
        }
        
        
        
        
        
        return false;
    }
}