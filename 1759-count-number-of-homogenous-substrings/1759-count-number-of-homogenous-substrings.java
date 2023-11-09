class Solution {
    public int countHomogenous(String s) {
        int rc = 0;
        char prev = 'A';
        int count = 0;
        int mod = (int)1e9+7;
        for (char c : s.toCharArray() ) {
            if ( prev != c ) 
                count = 0;
            prev = c;
            count++;
            rc = (rc+ count) % mod;
        }
        
        // System.out.println((int)(1e9+7));
        return rc;
    }
}