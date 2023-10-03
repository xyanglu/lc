class Solution {
    public int numIdenticalPairs(int[] nums) {
        int rc = 0;
        
        Map<Integer,Integer> map = new HashMap();
        for (int n : nums) {
            map.put(n,map.getOrDefault(n,0)+1);
            rc += map.get(n)-1;
            
        }
        
        
        return rc;
    }
}