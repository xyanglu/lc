class Solution {
    public int maxScore(String s) {
        int ones = 0;
        int max = 0;
        for ( char c : s.toCharArray() ) 
            if ( c == '1' ) 
                ones++;
        int zeroes = 0;
        for ( int i=0;i+1<s.length();i++ )
        {
            char c = s.charAt(i);
            if ( c == '0' ) {
                max = Math.max(max, zeroes + 1 + ones);
                zeroes++;
            }
            else {
                max = Math.max(max,zeroes + ones-1);
                ones--;
            }
        }
        
        return max;
    }
}