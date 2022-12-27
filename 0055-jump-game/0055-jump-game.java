class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        dp[nums.length-1] = 1;
        
        for (int i=nums.length-2;i>=0;i--) {
            boolean success = false;
            
            for (int j=1;j<=nums[i];j++)
                if ( i+j < nums.length && dp[i+j] == 1 )
                {
                    success = true;
                    break;
                }
            
            dp[i] = success ? 1 : 0;
        }
        
        
        //System.out.println(Arrays.toString(dp));
        return dp[0] == 1;
    }
}