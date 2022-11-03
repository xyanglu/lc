class Solution {
    public int longestPalindrome(String[] words) {
        Map<String,Integer> map = new HashMap();
        int mid = 0;
        for (String w : words) 
            map.put(w,map.getOrDefault(w,0)+1);
        
        Set<String> set = new HashSet();
        int max = 0;
        
        for (String key : map.keySet()) {
            String rev = key.charAt(1) +""+ key.charAt(0);
            if ( !key.equals(rev) && map.containsKey(rev) ) {
                int val = Math.min(map.get(rev),map.get(key));
                //System.out.println(key+ ""+rev+""+val);
                map.put(rev,map.get(rev)-val);
                map.put(key,map.get(key)-val);
                max += val * 4;
            }
            if ( rev.equals(key) ) {
                    int val = map.get(key) / 2;
                  map.put(key,map.get(key)-val*2);
                max += val * 4;
            }
            if ( rev.equals(key) &&  map.get(key) > 0 )
                mid = 2;
        }
        return max + mid;
        
        
    }
}