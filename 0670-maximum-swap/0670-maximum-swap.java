class Solution {
    public int maximumSwap(int num) {
        StringBuilder sb = new StringBuilder ( String.valueOf(num));
        int n = sb.length();
        int[][] rc = new int[n][2];
        int max = 0;
        int coord = 0;
        for ( int i=n-1;i>=0;i--) {
            char c = sb.charAt(i);
            if ( c - '0' > max ) {
                coord = i;
                max = c-'0';
            }
            rc[i] = new int[]{ max, coord};
        }
        
        for ( int i=0;i<n;i++) {
            char c = sb.charAt(i);
            if ( rc[i][0] > c - '0' )
            {
                sb.setCharAt(i, (char) (rc[i][0]+'0'));
                sb.setCharAt(rc[i][1], c);
                break;
            }
        }
        
        
        
        return Integer.parseInt( sb.toString() ) ;
    }
}