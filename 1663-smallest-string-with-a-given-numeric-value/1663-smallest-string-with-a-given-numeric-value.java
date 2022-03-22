class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while ( k > 0) {
            char c = (char) ( Math.min(25, k-n) + 'a');
            sb.append(c);
            k -= c - 'a' + 1;
            n--;
        }
        
        return sb.reverse().toString();
        //26 or k - n + 1
    }
}