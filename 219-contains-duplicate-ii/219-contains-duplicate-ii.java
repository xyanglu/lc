class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        for (int i=0;i<nums.length;i++)
        {
            int v = nums[i];
            
            if ( map.containsKey(v) && i - map.get(v) <= k )
                return true;
            map.put(v,i);
        }
        
        return false;
    }
}