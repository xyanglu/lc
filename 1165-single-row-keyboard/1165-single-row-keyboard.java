class Solution {
    public int calculateTime(String keyboard, String word) {
        int prev = 0;
        Map<Character,Integer> map = new HashMap();
        int i = 0;
        for ( char c : keyboard.toCharArray() )
            map.put(c,i++);
        
        int rc = 0;
        for ( char c : word.toCharArray() )
        {
            rc += Math.abs( map.get(c) - prev);
            prev = map.get(c);
        }
        return rc;
        
        
    }
}