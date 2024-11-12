class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] rc = new int[queries.length];
        
        Arrays.sort(items,(a,b)-> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0] );
        for (int i=1;i<items.length;i++)
            items[i][1] = Math.max(items[i-1][1],items[i][1]);
        
        // for (int[] item : items)
        //     System.out.println(Arrays.toString(item));
        
        for (int i=0;i<queries.length;i++) 
        {
            int l = 0, r = items.length-1;
            int prev = 0;
            while ( l <= r ) {
                int m = (l+r)/2;
                if ( items[m][0] <= queries[i] ) {
                    prev = items[m][1];
                    l = m + 1;
                }
                else {
                    r = m - 1;
                }
                
            }
            rc[i] = prev;
            
        }
        
        
        return rc;
    }
}