class Solution {
    public int longestPalindrome(String s) {
        boolean odd = false;
        int rc = 0;
        
        Map<Character,Integer> map = new HashMap();
        for( char c : s.toCharArray() )
            map.put(c,map.getOrDefault(c,0)+1);
        
        for ( char c : map.keySet() ) {
            if ( odd ) {
                if ( map.get(c) % 2 == 1 )
                    rc += (map.get(c) - 1 );
                else
                    rc += map.get(c) ;
            }
            else {
                if ( map.get(c) % 2 == 1 )
                    odd = true;
                rc += map.get(c);
            }
        }
        
        
        return rc;
    }
}