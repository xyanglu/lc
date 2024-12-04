class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0;
        int j = 0;
        
        for (i=i;i<str1.length();i++) {
            if ( j == str2.length() ) return true;
            char c = str1.charAt(i);
            char d = str2.charAt(j);
            if ( c == d ) {
                j++;
            }
            if ( c + 1 == d ) {
                j++;
            }
            if ( c == 'z' && d == 'a' ) {
                j++;
            }
        }
        
        return j == str2.length();
    }
}