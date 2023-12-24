class Solution {
    public int minOperations(String s) {
        return Math.min(dfs(s,0,false),dfs(s,0,true));
    }
    int dfs(String s, int i, boolean zero) {
        if ( i == s.length() ) return 0;
        int val = zero && s.charAt(i) == '0' ? 0 : !zero && s.charAt(i) == '1' ? 0 : 1;  
        return val + dfs(s,i+1, !zero);
    }
}