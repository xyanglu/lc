class Solution {
    int rc = 0;
    public int beautifulSubsets(int[] nums, int k) {
        dfs(nums,0,k,new HashMap<Integer,Integer>());
        return rc;
    }
    void dfs(int[] nums, int i, int k, Map<Integer,Integer> map) {
        if ( i == nums.length ) {
            return;
        }
        int v = nums[i];
        if ( map.containsKey(v-k) || map.containsKey(v+k) ) {
                    dfs(nums,i+1,k,map);
        }
        else {
            rc++;
            map.put(v,map.getOrDefault(v,0)+1);
            dfs(nums,i+1,k,map);
            map.put(v,map.get(v)-1);
            if ( map.get(v) == 0 )
                map.remove(v);
            dfs(nums,i+1,k,map);
        }
    }
}