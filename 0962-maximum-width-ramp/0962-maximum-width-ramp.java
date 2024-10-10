class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int rc = 0;
        
        int[] max = new int[n];
        int m = 0;
        for (int i=n-1;i>=0;i--) {
            m = Math.max(m,nums[i]);
            max[i] = m;
        }
        
        int l = 0;
        int r = l;
        while ( r < nums.length ) {
            if ( nums[l] > max[r] ) {
                l++;
                r = l;
            }
            rc = Math.max(rc,r-l);
            r++;
        }
        
        return rc;
        
        
    }
}