class Solution {
    public long distinctNames(String[] ideas) {
        Map<Character,Set<String>> map = new HashMap();
        for ( String i : ideas)
        {
            char p = i.charAt(0);
            String suf = i.substring(1,i.length());
            if ( !map.containsKey(p) )
                map.put(p,new HashSet());
            map.get(p).add(suf);
        }
        
        long rc = 0;
        for ( char c : map.keySet() ) {
            
                for ( char d : map.keySet() ) {  
                    if ( c == d ) continue;
                                    int intersect = 0;

                    for ( String suf : map.get(c) ) {
                        if ( map.get(d).contains(suf) )
                            intersect++;
                    }
                rc += (map.get(c).size() - intersect)*(map.get(d).size()-intersect) ;
            }
        }
        //System.out.println(set);
        return rc;
        
        
    }
}