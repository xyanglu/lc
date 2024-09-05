class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] rc = new int[n];
        int sum = mean * ( rolls.length + n );
        for (int r: rolls)
            sum -= r;
        if ( sum < n || sum > 6*n ) return new int[0];
        
        while ( n > 0 ) {
            rc[n-1] = sum / n;
            sum -= rc[n-1];
            n--;
        }
        
        return rc;
    }
}