class Solution {
    public String orderlyQueue(String s, int k) {
        if ( k > 1 ) {
        char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String( arr );
        }
        String rc = s;
        for (int i=0;i<s.length();i++) {
            String temp = s.substring(i) + s.substring(0,i);
            if ( temp.compareTo(rc) < 0 )
                rc = temp;
        }
        return rc;
    }
}