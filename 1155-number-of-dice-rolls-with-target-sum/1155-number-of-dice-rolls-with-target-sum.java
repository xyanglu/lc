class Solution {
    Map<String,Integer> map = new HashMap();
    public int numRollsToTarget(int n, int k, int target) {
        return dfs(n,k,target) % (int) (1e9+7);
    }
    int dfs(int n, int k, int target) {
        if ( target < 0 ) return 0;
        if ( n * k < target ) return 0;
        if ( n == 0 && target == 0 ) return 1;
        if ( map.containsKey(n+" "+target)) return map.get(n+" "+target);
        
        int val = 0;
        for (int i=1;i<=k;i++) {
            val = ( val + dfs(n-1,k,target-i) ) % (int) (1e9+7);
        }
        
        map.put(n+" "+target,val);
        
        return val ;
    }
}