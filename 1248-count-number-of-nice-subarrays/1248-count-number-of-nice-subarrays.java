class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int rc = 0;
        
        Map<Integer,Integer> map = new HashMap();
        map.put(0,1);
        int odd = 0;
        
        for ( int n : nums) {
            if ( n % 2 == 1 ) odd++;
            if ( map.containsKey(odd-k) )
                rc += map.get(odd-k);
            map.put(odd,map.getOrDefault(odd,0)+1);
        }
        
        
        return rc;
    }
}