class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = first(nums,target);
        int last = last(nums,target);
        
        return new int[]{first,last};
    }
    int first(int[] nums, int target) {
        int prev = -1;
        int l =0, r = nums.length - 1;
        while ( l <= r )
        {
            int m = (l+r)/2;
            if ( nums[m] == target )
            {
                prev = m;
                r = m - 1;
            }
            else if ( nums[m] < target )
                l = m + 1;
            else if ( nums[m] > target ) 
                r = m - 1;
        }
        return prev;
    }
    int last(int[] nums, int target) {
        int prev = -1;
        int l =0, r = nums.length - 1;
        while ( l <= r )
        {
            int m = (l+r)/2;
            if ( nums[m] == target )
            {
                prev = m;
                l = m + 1;
            }
            else if ( nums[m] < target )
                l = m + 1;
            else if ( nums[m] > target ) 
                r = m - 1;
        }
        return prev;
    }
}