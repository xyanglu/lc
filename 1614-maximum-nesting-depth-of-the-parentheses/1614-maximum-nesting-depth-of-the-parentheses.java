class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int cur = 0;
        for ( char c : s.toCharArray() ) {
            if ( c == '(')
                cur++;
            else if ( c == ')')
                cur--;
            max = Math.max(max,cur);
        }
        return max;
    }
}