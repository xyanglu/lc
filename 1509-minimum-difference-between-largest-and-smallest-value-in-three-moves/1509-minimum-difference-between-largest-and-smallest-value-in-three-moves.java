class Solution {
    public int minDifference(int[] nums) {        
        Arrays.sort(nums);
        return dfs(nums,3);

    }
    int dfs(int[] nums, int k) {
        if ( nums.length < 2 ) return 0;
        
        int n = nums.length;
        if ( k == 0 ) return nums[n-1] - nums[0];
        
        int left = nums[n-2] - nums[0];
        int right = nums[n-1] - nums[1];
        
        int[] l = Arrays.copyOfRange(nums,0,n-1);
        int[] r = Arrays.copyOfRange(nums,1,n);
        
        return Math.min( Math.min(left,dfs(l,k-1)),Math.min(right,dfs(r,k-1)) );
        
    }
}