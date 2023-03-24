class Solution {
    Map<Integer,Set<Integer>> map = new HashMap();
    Set<Integer> set = new HashSet();
    Set<String> connects = new HashSet();
    int rc = 0;
    public int minReorder(int n, int[][] connections) {
        for (int i=0;i<n;i++)
            map.put(i,new HashSet());
        for (int[] c : connections)
        {
            connects.add(c[0] +" "+c[1]);
            map.get(c[0]).add(c[1]);
            map.get(c[1]).add(c[0]);
        }
        set.add(0);
        dfs(0);
        return rc;
    }
    void dfs( int i) {
        for (int neigh : map.get(i) ) {
            if ( set.contains(neigh )) continue;
            if ( !connects.contains(neigh+" "+i) )
                rc++;
            set.add(neigh);
            dfs(neigh);

        }
    }
}