class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int cur = 0;
        for ( char c : s.toCharArray() ) {
            cur += c == '(' ? 1 : c == ')' ? -1 : 0;
            max = Math.max(max,cur);
        }
        return max;
    }
}