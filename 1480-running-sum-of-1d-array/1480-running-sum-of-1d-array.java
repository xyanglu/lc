class Solution {
    public int[] runningSum(int[] nums) {
        int rc = 0;
        
        for (int i=0;i<nums.length;i++)
        { 
            nums[i] += rc;
            rc = nums[i];
        }
        
        return nums;
    }
}