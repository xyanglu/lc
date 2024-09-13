class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] rc = new int[queries.length];
        
        for (int i=1;i<arr.length;i++)
            arr[i] ^= arr[i-1];
            
        for (int i=0;i<queries.length;i++) {
            int l = 0;
            if ( queries[i][0] > 0 )
                l = arr[queries[i][0]-1];
            rc[i] = l ^ arr[queries[i][1]];
        }
        return rc;
        
    }
}