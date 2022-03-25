class Solution {
    public boolean isIsomorphic(String s, String t) {
        StringBuilder ss = new StringBuilder();
        int i = 0;
        Map<Character,Integer> map = new HashMap();
        for ( char c : s.toCharArray() ) {
            if ( !map.containsKey(c) )
                map.put(c,i++);
            ss.append( map.get(c) + " ");
        }
        
        StringBuilder st = new StringBuilder();
        i = 0;
        map = new HashMap();
        for ( char c : t.toCharArray() ) {
            if ( !map.containsKey(c) )
                map.put(c,i++);
            st.append( map.get(c) + " " );
        }
        
        System.out.println( ss.toString() + " " + st.toString() );
        return ss.toString().equals(st.toString());
    }
}