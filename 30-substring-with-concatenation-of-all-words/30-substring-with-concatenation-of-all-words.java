class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int len = words[0].length();
        List<Integer> list = new ArrayList();
        for (int i=0;i+len*words.length<=s.length();i++) {
            Map<String,Integer> map = new HashMap();
            for ( String w: words)
                map.put(w,map.getOrDefault(w,0)+1);
            String sub = s.substring(i,Math.min(s.length(),i+len));
            int j = i;
            while ( map.containsKey(sub) ) {
                map.put(sub,map.get(sub)-1);
                if ( map.get(sub) == 0 ) 
                    map.remove(sub);
                if ( map.size() == 0 )
                    list.add(i);
                j += len;
                sub = s.substring(j,Math.min(s.length(),j+len));
            }
        }
        return list;
    }
}