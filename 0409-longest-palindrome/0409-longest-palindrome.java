class Solution {
    public int longestPalindrome(String s) {
        int rc = 0;
        
        Map<Character,Integer> map = new HashMap();
        for( char c : s.toCharArray() )
            map.put(c,map.getOrDefault(c,0)+1);
        
        for ( char c : map.keySet() ) 
                rc += map.get(c) + ( rc % 2 == 1 && map.get(c) % 2 == 1 ? -1 : 0 );

        
        
        return rc;
    }
}