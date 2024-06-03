class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0, j = 0;
        int n = s.length(), m = t.length();
        
        for (j=j;j<n;j++) {
            if ( i < t.length() && t.charAt(i) == s.charAt(j) )
                i++;
        }
        
        return m - i;
        
    }
}