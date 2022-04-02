class Solution {
    public int integerReplacement(int n) {
        if ( n == 1 ) return 0;
        if ( n == Integer.MAX_VALUE) return 32;
        //3
        if ( n % 2 == 0 ) return 1 + integerReplacement(n/2);
        return Math.min(1 + integerReplacement(n-1),1 + integerReplacement(n+1));
        //5
    }
}