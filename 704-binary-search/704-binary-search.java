class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1 ;
        while ( l <= r ) {
            int mid = (l + r)/2;
            int val = nums[mid];
            if ( nums[mid] == target )
                return mid;
            else if ( target < val )    
                r = mid - 1;
            else 
                l = mid + 1;    
        }
        
        return -1;   
    }
}