class Solution {
    public int longestPalindrome(String s) {
        int rc = 0;
        Set<Character> set = new HashSet();
        for ( char c : s.toCharArray() )
            if ( set.contains(c) )
            {
                rc += 2;
                set.remove(c);
            } 
            else
                set.add(c);
        
        
        return rc + ( (set.size()>0)?1:0 ) ;
    }
}