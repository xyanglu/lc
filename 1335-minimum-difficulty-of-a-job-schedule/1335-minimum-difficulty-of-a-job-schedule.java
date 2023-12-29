class Solution {
    Map<String,Integer> map = new HashMap();
    public int minDifficulty(int[] jobDifficulty, int d) {
        if ( jobDifficulty.length < d ) return -1;
        return dfs(0,jobDifficulty,d,-1);
    }
    int dfs(int i, int[] jb, int d, int max) {
        if ( map.containsKey(i+" "+d+" "+max)) return map.get(i+" "+d+" "+max);
        if ( d == 0 &&  i == jb.length ) return 0;
        if ( d == 0 || i == jb.length ) return 10000;
        
        max = Math.max(max,jb[i]);
        //take
        int min = dfs(i+1,jb,d,max);
        
        //ignore
        min = Math.min(min,max + dfs(i+1,jb,d-1,-1));
        
        map.put(i+" "+d+" "+max,min);
        return min;
        
    }
}