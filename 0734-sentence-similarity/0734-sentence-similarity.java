class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if ( sentence1.length != sentence2.length ) return false;
        Map<String,Set<String>> map = new HashMap();
        for ( List<String> l : similarPairs ) {
            String s1 = l.get(0);
            String s2 = l.get(1);
            
            if ( !map.containsKey(s1) )
                map.put(s1,new HashSet());
            map.get(s1).add(s2);
            if ( !map.containsKey(s2) )
                map.put(s2,new HashSet());
            map.get(s2).add(s1);
            
        }
        //System.out.println(map);
        
        for (int i=0;i<sentence1.length;i++) {
            String s1 = sentence1[i];
            String s2 = sentence2[i];
            if ( s1.equals(s2) ) continue;
            if ( map.containsKey(s1) && map.get(s1).contains(s2) ) continue;
            return false;
            
        }
        
        
        return true;
    }
}