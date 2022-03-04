class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int maxSoFar = nums[0];
        
        for (int i=1;i<nums.length;i++) {
            maxSoFar = Math.max(nums[i],maxSoFar+nums[i]);
            max = Math.max(maxSoFar,max);
        }
        
        return max;
    }
}