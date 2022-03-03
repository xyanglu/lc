class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int cur = 0;
        int sum = 0;
        
        for (int i=0;i+2<nums.length;i++)
        {
            if ( nums[i+1] - nums[i] == nums[i+2] - nums[i+1] )
            {
                cur++;
                sum+=cur;
            }
            else
                cur = 0;
        }
        
        return sum;
    }
}