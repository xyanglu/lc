class Solution {
    Map<String,Integer> map = new HashMap();
    public int getLengthOfOptimalCompression(String s, int k) {
        return dfs(0,s,k,'#',0);    
    }
    int dfs(int i, String s, int k, char prev, int prev_c) {
        String key = i+" "+k+" "+prev+" "+prev_c;
        if ( map.containsKey(key) ) return map.get(key);
        if ( k < 0 ) return 10000;
        if ( i == s.length() - k ) return 0;    
        
        char c = s.charAt(i);
        int val = 0;
        if ( c == prev ) {
            int bump = prev_c == 1 || prev_c == 9 || prev_c == 99 ? 1 : 0;
            val = bump + dfs(i+1,s,k,prev,prev_c+1);
        }
        else {
            val = Math.min( dfs(i+1,s,k-1,prev,prev_c), 1 + dfs(i+1,s,k,c,1)  );
        }
        
        map.put(key,val);
        return val;
    }
}