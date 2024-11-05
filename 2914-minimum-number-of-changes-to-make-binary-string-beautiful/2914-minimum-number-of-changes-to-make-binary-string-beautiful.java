class Solution {
    public int minChanges(String s) {
        int rc = 0;
        int prev = 0;
        
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            int cur = c-'0';
            if ( i % 2 == 1 ) {
                if ( cur == 1 && prev != cur ) {
                    cur = 0;
                    rc++;
                }
                else if ( cur == 0 && prev != cur ) {
                    cur = 1;
                    rc++;
                }
            }
            prev = c-'0';
        }
        
        return rc;
    }
}