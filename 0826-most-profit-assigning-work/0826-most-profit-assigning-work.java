class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] arr = new int[profit.length][2];
        for (int i=0;i<profit.length;i++)
            arr[i] = new int[]{difficulty[i],profit[i]};
        
        Arrays.sort(arr,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        
        
        List<int[]> list = new ArrayList();
        int prev = 0;
        for (int[] a : arr)
        {
            if ( a[1] < prev ) continue;
            list.add(a);
            prev = a[1];
        }
        
        
        
        int rc = 0;
        
        for (int w : worker) {
            int l = 0, r = list.size() - 1;
            int pro = 0;
            while ( l <= r ) {
                int m = (l+r)/2;
                if ( m < list.size() && list.get(m)[0] <= w ) {
                    pro = list.get(m)[1];
                    l = m + 1;                
                }
                else
                    r = m - 1;
            }
            rc += pro;
            
            
            
        }
        
        
        
        return rc;
    }
}