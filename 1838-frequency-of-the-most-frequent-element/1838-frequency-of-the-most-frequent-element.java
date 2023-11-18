class Solution {
    public int maxFrequency(int[] nums, int k) {
       Arrays.sort(nums);
        
        int max = 0;
        Set<Integer> set = new HashSet();
        for (int i=nums.length-1;i>=0;i--)
        {
            if ( set.contains(nums[i])) continue;
            set.add(nums[i]);
            int val = k;
            int rc = 1;
            for (int j=i-1;j>=0;j--)
            {
                if ( nums[j] + val < nums[i] ) break;
                if ( nums[j] + val >= nums[i] ) {
                    val -= nums[i] - nums[j];
                    rc++;
                }    
            }
            max = Math.max(max,rc);
            
        }
        
        
        return max;
        
    }
}