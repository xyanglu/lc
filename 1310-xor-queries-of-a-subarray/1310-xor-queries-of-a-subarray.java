class Solution {
    public int[] xorQueries(int[] arr, int[][] q) {
        int[] rc = new int[q.length];
        
        for (int i=0;i<q.length;i++) {
            int[] qu = q[i];
            int v = 0;
            for (int j=qu[0];j<=qu[1];j++)
                v ^= arr[j];
            rc[i] = v;
        }
        
        return rc;
    }
}