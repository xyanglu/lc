class Solution {
    Map<Integer,Boolean> map = new HashMap();
    public boolean checkValidString(String s) {
        return dfs(s,0,0,0);
    }
    boolean dfs(String s, int i, int st, int e) {
        if ( i == s.length() ) return st == 0;
        if ( st < 0 ) return false;
        // if ( map.containsKey(i) ) return map.get(i);
        boolean rc = false;
        char c = s.charAt(i);
        if ( c == '(' )
            rc = dfs(s,i+1,st+1,e);
        else if ( c == '*' )
        {
            if ( st > 0)
                rc |= dfs(s,i+1,st-1,e);
            rc |= dfs(s,i+1,st,e+1);
        }
        else {
            if ( st == 0 && e == 0 ) return false;
            if ( st > 0 )
            rc = dfs(s,i+1,st-1,e);
            else
                rc = dfs(s,i+1,st,e-1);
        } 
        if ( rc )
            map.put(i,rc);
        return rc;
    }
}