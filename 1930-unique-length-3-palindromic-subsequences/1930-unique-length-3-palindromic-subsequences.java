class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> seenLeft = new HashSet();
        Set<String> match = new HashSet();
        Map<Character,Integer> map = new HashMap();
        for ( char c : s.toCharArray() ) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (char c : s.toCharArray()) {
                        map.put(c,map.get(c)-1);
            for ( char d : seenLeft) 
            {
                if ( map.get(d) > 0 ) {
                    match.add(""+d+c+d);
                }
            }
            seenLeft.add(c);
        }
        return match.size();
        
        
    }
}