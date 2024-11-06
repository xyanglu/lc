class Solution {
    Set<int[]> set = new HashSet();
    public boolean canSortArray(int[] nums) {
        if ( set.contains(nums) ) return false;
        int prev = 0;
        boolean sorted = true;
        for (int n : nums) {
            if ( n < prev ) 
                sorted = false;
            prev = n;
        }
        if ( sorted ) return true;
        
        // System.out.println(Arrays.toString(nums));
        for (int i=0;i+1<nums.length;i++) {
           int a = Integer.bitCount(nums[i]);
            int b = Integer.bitCount(nums[i+1]);
            if ( a == b && nums[i] > nums[i+1] ) {
                // System.out.println(nums[i]+" "+a+" "+nums[i+1]+" "+b);
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
                if ( canSortArray(nums) ) 
                    return true;
                temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }
        set.add(nums);
        return false;
    }
}