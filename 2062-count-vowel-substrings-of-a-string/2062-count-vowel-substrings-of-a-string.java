class Solution {
    public int countVowelSubstrings(String word) {
        int rc = 0;
        int vow = 0;
        int l = 0;
        int k = 0;
        
        Map<Character,Integer> map = new HashMap();
        map.put('a',0);
        map.put('e',0);
        map.put('i',0);
        map.put('o',0);
        map.put('u',0);
        
        for (int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if ( map.containsKey(c) ) {
                map.put(c,map.get(c)+1);
                if ( map.get(c) == 1 )
                    vow++;
                while ( vow == 5 ) {
                    char d = word.charAt(k++);
                    map.put(d,map.get(d)-1);
                    if ( map.get(d) == 0 )
                        vow--;
                }
                rc += k-l;

            }
            else {
                map.put('a',0);
                map.put('e',0);
                map.put('i',0);
                map.put('o',0);
                map.put('u',0);
                vow = 0;
                l = k = i + 1;
            }
        }
        return rc;
    }
}