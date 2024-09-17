class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String,Integer> map1 = new HashMap();

        for ( String w : s1.split(" "))
            map1.put(w,map1.getOrDefault(w,0)+1);
        for ( String w : s2.split(" ")) 
            map1.put(w,map1.getOrDefault(w,0)+1);
        
        int count = 0;
        for ( String w : map1.keySet() )
            if ( map1.get(w) == 1 )
                count++;
        
        String[] rc = new String[count];
        for ( String w : map1.keySet() )
        {
            if ( map1.get(w) == 1 )
                rc[count-- - 1] = w;
        }
        return rc;
        
    }
}