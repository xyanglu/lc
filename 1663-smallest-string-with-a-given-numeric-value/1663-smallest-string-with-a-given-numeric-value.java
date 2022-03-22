class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while ( k > n ) {
            char c = (char) ( Math.min(26, k-n+1) - 1 + 'a');
            sb.append(c);
            k -= c - 'a' + 1;
            n--;
        }
        
        while ( n > 0 ) {
            sb.append('a');
            n--;
        }
        
        return sb.reverse().toString();
        //26 or k - n + 1
    }
}