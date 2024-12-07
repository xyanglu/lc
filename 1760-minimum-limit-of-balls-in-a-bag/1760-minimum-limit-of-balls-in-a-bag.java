class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1;
        int r = 0;
        for (int n : nums)
            r = Math.max(r,n);
        int M = nums.length + maxOperations;
        
        while (l < r ) {
            int m = (l+r)/2;
            long temp = 0;
            for (int n : nums)
                temp += (int) Math.ceil(1.0*n/m);
            if ( temp <= M ) 
                r = m;
            else
                l = m + 1;
            
        }
        
        
        return r;
    }
}