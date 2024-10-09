class Solution {
    public int minAddToMakeValid(String s) {
        int o = 0;
        int cl = 0;
        int rc = 0;
        
        for ( char c : s.toCharArray() ) {
            if ( c == '(') o++;
            else if ( c == ')') {
                                cl++;
                if ( o < cl ) {
                    o++;
                    rc++;
                }
            }
        }
        return rc + ( o - cl );
        
        
    }
}