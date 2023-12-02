class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character,Integer> map = new HashMap();
        for (char c : chars.toCharArray()) 
            map.put(c,map.getOrDefault(c,0)+1);
        
        int rc =0 ;
        
        for ( String w : words) {
            Map<Character,Integer> used = new HashMap();
            boolean good = true;
            for ( char c : w.toCharArray())
            {
                if ( !map.containsKey(c) || used.getOrDefault(c,0)+1 > map.get(c) ) {
                    good = false;
                    break;
                }
                used.put(c,used.getOrDefault(c,0)+1);
            }
            if ( good )
                rc += w.length();
            
        }
        
        
        return rc;
    }
}