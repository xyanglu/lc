class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if ( n > m )
            return findMedianSortedArrays(nums2,nums1);
        
        int l = 0, r = nums1.length - 1;
        while ( true ) {
            int i = (int) Math.floor( (l+r) / 2.0f );
            int j = (n+m)/2 - 2 - i;
            int Aleft = Integer.MIN_VALUE;
            int Aright = Integer.MAX_VALUE;
            int Bleft = Integer.MIN_VALUE;
            int Bright = Integer.MAX_VALUE;
            if ( i != - 1 )
                Aleft = nums1[i];
            if ( i + 1 < n)
                Aright = nums1[i+1];
            if ( j != -1 )
                Bleft = nums2[j];
            if ( j + 1 < m )
                Bright = nums2[j+1];
            if ( Aleft <= Bright && Bleft <= Aright)
            {
                if ( (n+m) % 2 == 0 )
                    return ( Math.max(Aleft,Bleft) + Math.min(Aright,Bright)  ) /2.0f;
                else
                    return Math.min(Aright,Bright);
            }
            else if ( Aleft > Bright)
                r = i-1;
            else
                l = i+1;
        }
    }
}