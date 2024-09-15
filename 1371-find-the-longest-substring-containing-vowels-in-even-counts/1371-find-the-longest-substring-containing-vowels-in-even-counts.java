class Solution {
    public int findTheLongestSubstring(String s) {
        Map<String,Integer> map = new HashMap();
        map.put("aeiou",-1);
        Map<Character,Integer> key = new TreeMap();
        key.put('a',0);
        key.put('e',0);
        key.put('i',0);
        key.put('o',0);
        key.put('u',0);
        
        int max = 0;
        for ( int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            key.put(c,key.getOrDefault(c,0)+1);
            String k = "";
            for ( char ke : key.keySet() )
                if ( key.get(ke) % 2 == 0 )
                    if ( ke == 'a' || ke == 'i' || ke == 'e' || ke == 'o' || ke == 'u' ) 
                        k+=ke;
            if ( !map.containsKey(k) )
                map.put(k,i);
            else {
                // System.out.println(c+" "+k+" "+i+" "+map.get(k));
                max = Math.max(max,i-map.get(k));
            }
        }
        return max;
        
    }
}