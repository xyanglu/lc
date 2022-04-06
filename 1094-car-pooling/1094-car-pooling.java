class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] r = new int[1001];
        for (int[] t : trips) {
            r[t[1]] += t[0];
            r[t[2]] -= t[0];
        }
              int cur = 0;
        for (int i=0;i<r.length;i++) {
             cur += r[i];
            if ( cur > capacity) 
                return false;
        }
        
        return true;
    }
}