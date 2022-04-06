class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] r = new int[3001];
        for (int[] t : trips) {
            for (int s=t[1];s<t[2];s++)
                r[s] += t[0];
        }
        for (int i=0;i<r.length;i++)
            if ( r[i] > capacity) 
                return false;
        
        return true;
    }
}