class Solution {
    
    Set<List<Integer>> rc = new HashSet();
    List<Integer> list = new ArrayList();
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0,nums);
        return new ArrayList(rc);
    }
    void dfs(int i, int[] nums) {
        if ( i == nums.length ) {
            if ( list.size() >= 2 )
                rc.add(new ArrayList(list));
            return;
        }
        if ( list.size() == 0 || list.get(list.size()-1) <= nums[i] ) {
            list.add(nums[i]);
            dfs(i+1,nums);
            list.remove(list.size()-1);
        }
        dfs(i+1,nums);
    }
}