class Solution {
    public int takeCharacters(String s, int k) {
        Map<Character,Integer> map = new HashMap();
        for ( char c : s.toCharArray() ) 
            map.put(c,map.getOrDefault(c,0)+1);
        
        if ( k == 0 ) return 0;
        if ( map.size() < 3 || map.get('a') < k || map.get('b') < k || map.get('c') < k ) return -1;
        
        int max = Integer.MAX_VALUE; 
        int l = 0;
        for (int r=0;r<s.length();r++) {
            char c = s.charAt(r);
            map.put(c,map.get(c)-1);
            while (  map.get('a') < k || map.get('b') < k || map.get('c') < k  )
            {
                char d = s.charAt(l++);
                map.put(d,map.get(d)+1);
            }
            max = Math.min(max, s.length() - ( r - l + 1) );
        }
        
        return max;
    }
}