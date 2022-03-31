class Solution {
    public int splitArray(int[] nums, int m) {
        int l = 0, r = 0;
        for (int n : nums) {
            r+=n;
            l = Math.max(l,n);
        }

        while ( l < r ) {
            int mid = (l+r)/2;
            if ( split(nums,mid,m) )
                r = mid;
            else
                l = mid+1;
        }
        return l;
    }
    boolean split(int[] nums, int size, int m) {
        int buckets = 1;
        int cur = 0;
        for (int n : nums) {
            if ( cur + n > size )
            {
                cur = 0;
                buckets++;
            }
            cur+=n;
            
        }
        return buckets <= m;
    }
}