class Solution {
    public int findMaxK(int[] nums) {
        int rc = -1;
        Set<Integer> set = new HashSet();
        for (int n : nums)
        {
            if ( set.contains(-1*n) )
                rc = Math.max(rc,Math.abs(n));
            set.add(n);
            
        }
        return rc;
    }
}