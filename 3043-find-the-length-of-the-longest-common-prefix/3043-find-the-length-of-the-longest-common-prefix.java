class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TreeMap<String,String> map = new TreeMap<>();
        int longest = 0;
        for (int a : arr1 ) {
            String s = String.valueOf(a);
            map.put(s,s);
            longest = Math.max(longest, s.length());
        }
            
        int rc =0 ;
        
        for ( int a : arr2 ) {
            String s = String.valueOf(a);
            for (int i=1;i<=Math.min(s.length(),longest);i++) {
                String sub = s.substring(0,i);
                if ( map.containsKey(sub) ) 
                    rc = Math.max(rc,sub.length());
                if ( map.ceilingKey(sub)==null  )
                    break;
                else if ( map.ceilingKey(sub).startsWith(sub) ) {
                    // System.out.println("found ceiling key "+sub+" "+ map.ceilingKey(sub));
                    rc = Math.max(rc,sub.length());
                }
            }
            
            
        }

            
        
        return rc;
    }
}