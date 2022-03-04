class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        while ( i < nums.length ) {
            if ( nums[i] < nums.length && nums[i] != i )
            {
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
            else
                i++;
        }
        for (i=0;i<nums.length;i++)
            if ( i != nums[i] )
                return i;
        return i;
    }
}