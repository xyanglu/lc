class Solution {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length-1;
        for (int i=0;i<=r;) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[l];
                nums[l] = temp;
                l++;
                i++;
            } else if (nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[r];
                nums[r] = temp;
                r--;
            } else {
                i++;
            }
        }
    }
}
