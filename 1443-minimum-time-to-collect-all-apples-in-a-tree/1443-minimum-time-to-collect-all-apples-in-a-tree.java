class Solution {
    Set<String> set = new HashSet();
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer,List<Integer>> map = new HashMap();
        for (int i=0;i<n;i++) {
            map.put(i,new ArrayList<Integer>());
        }
        
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        
        dfs(0,map,new ArrayList<String>(),hasApple,new HashSet());
        
        return set.size() * 2;
    }
    void dfs(int i, Map<Integer,List<Integer>> map, List<String> path, List<Boolean> hasApple, Set<Integer> used) {
        if ( used.contains(i) ) return;
        used.add(i);
        if ( !map.containsKey(i) ) 
            return;
        if (  hasApple.get(i) ) {
            for ( String s : path )
                set.add(s);
        }
        for (int neigh : map.get(i) ) {
            path.add(i+" "+neigh);
            dfs(neigh,map,path,hasApple,used);
            path.remove(path.size()-1);
        }
    }
    
}