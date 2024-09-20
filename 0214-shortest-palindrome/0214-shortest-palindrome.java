class Solution {
    public String shortestPalindrome(String s) {      
        for (int i=s.length();i>0;i--) {
            String sub = s.substring(0,i);
            if ( isPalin(sub) )
            {
                StringBuilder sb = new StringBuilder(s.substring(i,s.length()));
                sb.reverse();
                sb.append(sub);
                sb.append(s.substring(i,s.length()));
                return sb.toString();
            }
            
        }
        return "";
    }
    boolean isPalin(String s) {
        int l=0,r=s.length()-1;
        while ( l < r ) {
            if ( s.charAt(l++) != s.charAt(r--) )
                return false;
        }
        return true;
    }
}