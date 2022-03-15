class Solution {
    public int minOperations(int[] nums) {
        int cost = 0;
        for (int i=1;i<nums.length;i++) {
            if ( nums[i-1] < nums[i] ) continue;
            int val = nums[i-1] + 1;
            cost += val - nums[i];
            nums[i] = val;
        }
        return cost;
    }
}