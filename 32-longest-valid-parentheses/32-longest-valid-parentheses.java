class Solution {
    int max = 0;
    public int longestValidParentheses(String s) {
        for (int i=0;i<s.length();i++) {
            int cur = 0;
            for (int j=i;j<s.length();j++) {
                char c = s.charAt(j);
                if ( c == '(')
                    cur++;
                else if ( c == ')')
                    cur--;
                if ( cur < 0 ) break;
                if ( cur == 0 ) 
                    max = Math.max(j-i+1,max);
            }
        }
        
        
        return max;
    }
}