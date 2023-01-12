class Solution {
    Map<Integer,int[]> cache = new HashMap();
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] rc = new int[n];
        
        Map<Integer,List<Integer>> map = new HashMap();
        for (int i=0;i<n;i++)
            map.put(i,new ArrayList());
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
            
        for (int i=0;i<n;i++)
        {
            int[] temp = dfs(i,map,labels, new HashSet());
            rc[i] = temp[labels.charAt(i)-'a'];
        }
            
        return rc;
    }
    int[] dfs (int i, Map<Integer,List<Integer>> map, String labels, Set<Integer> set) {
        if ( set.contains(i) ) return new int[26];
        if ( cache.containsKey(i) ) return cache.get(i);
        int[] temp = new int[26];
        temp[ labels.charAt(i) - 'a']++;
        set.add(i);
        
        for (int neigh : map.get(i) ) {
            int[] t = dfs(neigh,map,labels,set);
            for (int j=0;j<26;j++)
                temp[j] += t[j];
        }
        
        cache.put(i,temp);
        return temp;
        
    }
}