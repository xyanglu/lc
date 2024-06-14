class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        int rc = 0;
        for (int n : nums) {
            if ( n < max ) 
                rc += max - n;
            else
                max = n;
            max++;
        }
        return rc;
    }
}