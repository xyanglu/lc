class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        // System.out.println(Arrays.toString(g));
        // System.out.println(Arrays.toString(s));
        
        int i = 0, j = 0;
        int rc = 0;
        
        while ( i < g.length && j < s.length )
        {
            while ( j <s.length && g[i] > s[j] )
                j++;
            if ( j == s.length ) return rc;
            i++;
            j++;
            rc++;
        }
        
        
        return rc;
        
    }
}