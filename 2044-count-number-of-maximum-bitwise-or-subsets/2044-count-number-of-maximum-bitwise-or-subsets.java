class Solution {
            int rc = 0;
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (int n : nums)
            max |= n;
        
        dfs(0,nums,0,max);
        
        return rc;
    }
    void dfs(int i, int[] nums, int val, int max) {
        if ( i == nums.length ) return;
        
        
        dfs(i+1,nums,val,max);
        
        val |= nums[i];
        dfs(i+1,nums,val,max);
        
        if ( val == max ) rc++;
    }
    
}