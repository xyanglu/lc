class Solution {
    Map<String,Integer> map = new HashMap();
    public int numDecodings(String s) {
        if ( map.containsKey(s) ) return map.get(s);
                if ( s.length() == 0 ) return 1;
        if ( s.charAt(0) == '0' ) return 0;
        if ( s.length() == 1 ) return 1;
        String sub = s.substring(0,2);
        int val = ( sub.compareTo("26") > 0 ? 0 : numDecodings(s.substring(2,s.length())) ) + numDecodings(s.substring(1,s.length()));
        map.put(s,val);
        return val;        
        
    }
}