class Solution {
    public int[] findErrorNums(int[] nums) {
        
        Set<Integer> set = new HashSet();
        
        for (int n : nums)
            set.add(n);
        
        int miss = 0;
        for (int i=1;i<=nums.length;i++)
            if ( !set.contains(i) ) {
                miss = i;
                break;
            }

        set.clear();
        
        
        for (int i=0;i<nums.length;i++) {
            if ( set.contains(nums[i]))
                return new int[]{nums[i],miss};
            
            set.add(nums[i]);
        }
        
        
        return new int[2];
        
        
    }
}