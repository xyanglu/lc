class Solution {
    public int rob(int[] nums) {
        if ( nums.length == 1 ) return nums[0];
        int a = nums[0];
        int b = Math.max(a,nums[1]);
        for (int i=2;i<nums.length;i++)
        {
            if ( i % 2 == 0 )
                a = Math.max(nums[i]+a,b);
            else
                b = Math.max(nums[i]+b,a);
        }
        return Math.max(a,b);
    }
}