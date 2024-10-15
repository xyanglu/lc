class Solution {
    public long minimumSteps(String s) {
        long rc = 0;
        int n =s.length();
        long count = 0;
        for (int i=0;i<n;i++) {
            char c = s.charAt(i);
            if ( c == '1' ) 
                count++;
            else
                rc += count;
        }
        
        
        return rc;
    }
}