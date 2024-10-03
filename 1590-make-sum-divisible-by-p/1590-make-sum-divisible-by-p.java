class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for (int n : nums)
            sum += n%p;
        
        Map<Long,Integer> map = new HashMap();
        map.put((long)0,-1);
        sum %= p;
        if ( sum == 0 ) return 0;
        
        int rc = nums.length;
        
        long cur_sum = 0;
        for (int i=0;i<nums.length;i++) {
            int n = nums[i];
            cur_sum = (cur_sum + n) % p;
            long prefix = (cur_sum - sum + p) % p;
            if ( map.containsKey(prefix) )
                rc = Math.min(rc,(int)(i-map.get(prefix)));
            map.put(cur_sum,i);
        }
        
        return rc == nums.length ? -1 : rc;
    }
}