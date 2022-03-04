class Solution {
    String max = "";
    public String longestPalindrome(String s) {
        for (int i=0;i<s.length();i++) {
            dfs(s,i,i);
            dfs(s,i,i+1);
        }
        return max;
    }
    void dfs(String s, int i, int j) {
        while (i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)) 
        {
            if ( s.substring(i,j+1).length() > max.length() )
                max = s.substring(i,j+1);
            i--;
            j++;
        }

    }
}