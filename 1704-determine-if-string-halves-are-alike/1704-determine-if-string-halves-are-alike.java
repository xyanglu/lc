class Solution {
    public boolean halvesAreAlike(String s) {
        return dfs(s.substring(0,s.length()/2)) == dfs(s.substring(s.length()/2,s.length()));
    }
    int dfs(String s) {
        int rc = 0;
        s = s.toLowerCase();
        for ( char c : s.toCharArray() )
            if ( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' )
                rc++;
        
        return rc;
    }
}