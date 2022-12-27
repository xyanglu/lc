class Solution {
    int[] dp;
    public boolean canJump(int[] nums) {
        dp =  new int[nums.length];
        Arrays.fill(dp,-1);
        dp[nums.length-1] = 1;
        
        dfs(0,nums);
        //System.out.println(Arrays.toString(dp));
        
        return dp[0] == 1;
    }
    void dfs(int i, int[] nums) {
        if ( dp[i] != -1 ) return;
        for (int j=1;j<=nums[i];j++)
            if ( i + j < nums.length ) {
                                dfs(i+j,nums);
                if ( dp[i+j] == 1 )
                {
                    dp[i] = 1;
                    return;
                }
        }    
            dp[i] = 0;
    }
}