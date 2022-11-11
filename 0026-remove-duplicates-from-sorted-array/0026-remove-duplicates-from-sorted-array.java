class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        int max = -101;
        while ( j < nums.length ) {
            if ( nums[j] > max) {
            nums[i] = nums[j];
            max = nums[i];
            i++;
            }
            j++;
        }
        return i;
    }
}