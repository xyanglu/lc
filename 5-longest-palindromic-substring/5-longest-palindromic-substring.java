class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        
        for (int i=0;i<s.length();i++) {
            //odd
            int l=i,r=i;
            while (l>=0 && r<s.length() && s.charAt(l) == s.charAt(r) ) {
                if ( s.substring(l,r+1).length() > res.length() )
                    res = s.substring(l,r+1);
                l--;
                r++;
            }
            
            //even
            l=i;
            r=i+1;
            
            while (l>=0 && r<s.length() && s.charAt(l) == s.charAt(r) ) {
                if ( s.substring(l,r+1).length() > res.length() )
                    res = s.substring(l,r+1);
                l--;
                r++;
            }
        }
        
        return res;
    }
}