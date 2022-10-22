class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap();
        Map<Character,Integer> match = new HashMap();
        for ( char c : t.toCharArray() )
            match.put(c,match.getOrDefault(c,0)+1);
        
        int i = 0;
        String rc = "";
        StringBuilder sb = new StringBuilder();
        
        for ( char c : s.toCharArray() ) {
            if ( match.containsKey(c) )
                map.put(c,map.getOrDefault(c,0)+1);
            sb.append(c);
            
            while ( match(map,match) ) {
                if ( rc == "" || sb.length() < rc.length() )
                    rc = sb.toString();
                char d = s.charAt(i++);
                if ( match.containsKey(d) ) {
                    map.put(d,map.get(d)-1);
                    if ( map.get(d) == 0 )
                        map.remove(d);
                }
                sb = new StringBuilder(sb.substring(1));
            }
            
            
        }
        
        
        
        return rc;
        
            
    }
    boolean match(Map<Character,Integer> a, Map<Character,Integer> b ) {
        for ( char c : b.keySet() )
            if ( !a.containsKey(c) || a.get(c) < b.get(c) )
                return false;
        return true;
    }
}