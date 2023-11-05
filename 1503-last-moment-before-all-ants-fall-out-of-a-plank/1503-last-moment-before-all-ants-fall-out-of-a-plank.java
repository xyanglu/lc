class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        
        int l = left.length-1;
        int r = right.length-1;
        Arrays.sort(left);
        Arrays.sort(right);
        
        if ( l == -1 && r == -1 ) return 0;
        if ( l == -1 ) return n-right[0];
        if ( r == -1 ) return left[l];
        
        return Math.max(left[l],n-right[0]);
    }
}