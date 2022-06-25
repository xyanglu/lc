class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean changed = false;
        
        for (int i=0;i<nums.length-1;i++) {
            if ( nums[i] <= nums[i+1]) continue;
            if ( changed ) return false;
            
            // 3 4 2
            if ( i == 0 || nums[i+1] >= nums[i-1] ) 
                nums[i] = nums[i+1];
            else 
                nums[i+1] = nums[i];
            
            changed = true;
        }
        
        
        return true;
    }
}