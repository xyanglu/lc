class Solution {
    public int findDuplicate(int[] nums) {
        int lo = 1, hi = nums.length;
        while (true) {
            if ( lo == hi ) return lo;
            int mid = (lo+hi)/2;
            int count = count(nums,mid);
            System.out.println( mid + " " +count);
            if ( count >= mid + 1 )
                hi = mid;
            else
                lo = mid + 1;
        }
    }
    int count(int[] nums, int val ) {
        int c = 0;
        for (int n : nums)
            if ( n  <= val ) c++;
        return c;
    }
}