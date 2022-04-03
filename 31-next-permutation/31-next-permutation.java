class Solution {
    public void nextPermutation(int[] nums) {
        int end = nums.length -1;
        while ( end > 0 && nums[end-1] >= nums[end])
            end--;
        
        if ( end == 0 ) {
            for ( int i=0;i<nums.length/2;i++) 
                swap(i,nums.length-1-i,nums);
            return;
        }
        
        int start = end - 1;
        int swap = nums.length-1;
        for (swap=swap;swap>start;swap--)
            if ( nums[swap] > nums[start] )
                break;
        
        swap(swap,start,nums);
        
        int dist = nums.length - end;
        for (int i=0;i<dist/2;i++)
            swap(i + end, nums.length-1-i,nums);
        
    }
    void swap(int i, int j, int[] nums) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
    }
}