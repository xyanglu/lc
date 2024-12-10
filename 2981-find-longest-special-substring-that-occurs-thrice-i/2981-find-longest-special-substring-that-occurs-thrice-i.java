class Solution {
    public int maximumLength(String s) {
        int max = -1;
        Map<String,Integer> map = new HashMap<>();
        
        for (int i=1;i<=s.length();i++) {
            Map<String,Integer> temp = new HashMap(map);
            for (int j=0;j<i;j++) {
                String sub = s.substring(j,i);
                if ( sub.replaceAll(String.valueOf(sub.charAt(0)),"").length() != 0 ) continue;
                temp.put( sub, temp.getOrDefault(sub,0) + 1 );
            }
            map = temp;
        }
        
        // System.out.println(map);

        for (String key : map.keySet() ) {
            int value = map.get(key);
            if ( value > 2 )
                max = Math.max(max,key.length());
        }
        
        return max;
    }
}
