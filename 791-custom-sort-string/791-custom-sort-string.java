class Solution {
    public String customSortString(String order, String s) {
        int[] S = new int[26];
        for ( char c : s.toCharArray() )
            S[c-'a']++;
        
        StringBuilder sb = new StringBuilder();
        for ( int i=0;i<order.length();i++)
        {
            char c = order.charAt(i);
            while ( S[c-'a']>0)
            {
                sb.append(c);
                S[c-'a']--;
            }
        }
        
        for (int i=0;i<26;i++) {
            char c = (char) ('a' + i);
            while ( S[i]>0)
            {
                sb.append(c);
                S[i]--;
            }
        }
        return sb.toString();
    }
}