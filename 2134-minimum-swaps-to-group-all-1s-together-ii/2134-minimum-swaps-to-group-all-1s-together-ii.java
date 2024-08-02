class Solution {
    int ones = 0;
    public int minSwaps(int[] nums) {
        for (int n : nums)
            ones += n;
        int n = nums.length;
        int cur = 0;
        int l = 0;
        int min = ones;
        for (int i=0;i<nums.length*2;i++) {
            cur += nums[i%n];
            if ( i - l + 1 > ones) { 
                cur -= nums[l%n];
                l++;
            }

            // System.out.println(i+" "+cur);
            min = Math.min(ones-cur,min);
        }
        return min;
    }
}