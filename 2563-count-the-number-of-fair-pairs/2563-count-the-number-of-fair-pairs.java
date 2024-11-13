class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long rc = 0;
        
        Arrays.sort(nums);
        
        for (int i=0;i<nums.length;i++) 
        {
            int low = lower - nums[i];
            int up = upper - nums[i];
            
            rc += bin_search(i+1,nums.length-1,up+1,nums) - bin_search(i+1,nums.length-1,low,nums);
        }
        
        
        return rc;
    }
    int bin_search(int l, int r, int target, int[] nums){
        while ( l <= r) {
            int m = (l+r)/2;
            if ( nums[m] >= target ) 
                r = m - 1;
            else
                l = m + 1;
        }
        return r;
    }
}