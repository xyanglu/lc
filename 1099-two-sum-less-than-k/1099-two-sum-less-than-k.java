class Solution {
    int rc = 0;
    public int twoSumLessThanK(int[] nums, int k) {
        for (int i=0;i<nums.length;i++)
            for (int j=i+1;j<nums.length;j++)
                if ( nums[i] + nums[j] > rc && nums[i] + nums[j] < k) 
                    rc = nums[i] + nums[j];
        
        
        return rc == 0 ? -1 : rc;
    }
}