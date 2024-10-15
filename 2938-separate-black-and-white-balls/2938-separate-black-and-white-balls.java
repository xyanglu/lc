class Solution {
    public long minimumSteps(String s) {
        long rc = 0;
        int n =s.length();
        long count = 0;
        for (int i=n-1;i>=0;i--) {
            char c = s.charAt(i);
            if ( c == '0' ) 
                count++;
            else
                rc += count;
        }
        
        
        return rc;
    }
}