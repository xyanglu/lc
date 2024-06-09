class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int cur = 0;
        int rc = 0;
        Map<Integer,Integer> map = new HashMap();
        map.put(0,1);
        
        for (int n : nums) {
            while ( n < 0 ) 
                n += k;
            cur += n;
            cur %= k;
            // System.out.println(n+" "+cur);
            rc += map.getOrDefault(cur,0);
            map.put(cur, map.getOrDefault(cur,0)+1);
        }
        
        return rc;
    }
}