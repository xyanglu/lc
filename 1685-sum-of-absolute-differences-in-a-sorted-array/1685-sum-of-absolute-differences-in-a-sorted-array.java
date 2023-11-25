class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] rc = new int[nums.length];
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];
        int sum = 0;
        for (int i=0;i<l.length;i++)
        {
            l[i] = sum;
                        sum += nums[i];

        }
        sum = 0;
        for (int i=l.length-1;i>=0;i--) {
            r[i] = sum;
                        sum += nums[i];

        }
        
        for (int i=0;i<l.length;i++)
        {
            int           left = i * nums[i]  - l[i];
            int right = r[i] - (l.length-1-i) * nums[i];
            rc[i] = left + right;
        }
        
        
        return rc;
    }
}