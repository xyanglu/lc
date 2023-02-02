class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> map = new HashMap();
        for ( char c : order.toCharArray() )
            map.put(c,map.size());
        
        for ( int i=0;i+1<words.length;i++ ) {
            String w1 = words[i];
            String w2 = words[i+1];
            for (int j=0;j<w1.length();j++) {
                if ( j == w2.length() ) return false;
                char c = w1.charAt(j);
                char d = w2.charAt(j);
                if ( c == d ) continue;
                if ( map.get(c) > map.get(d) ) return false;
                break;
            }
        } 
            
            
        return true;
    }
}