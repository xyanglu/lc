class Solution {
    public int countNicePairs(int[] nums) {
        int rc = 0;
        
        Map<Integer,Integer> map = new HashMap();
        
        for (int n : nums) {
            int val = n-rev(n);
            rc = (int) (rc+ map.getOrDefault(val,0))%(int)(1e9+7);
            map.put(val,map.getOrDefault(val,0)+1);
        }
        
        return rc;
    }
    int rev(int n) {
        int r = 0;
        while ( n > 0 ) {
            r*=10;
            r += n%10;
            n/=10;
        }
        return r;
        
        
    }
}