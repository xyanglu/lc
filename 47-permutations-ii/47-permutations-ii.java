class Solution {
        List<List<Integer>> list = new ArrayList();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        dfs(nums,new boolean[8], new ArrayList());
        return list;
    }
    void dfs(int[] nums, boolean[] b, List<Integer> temp) {
        if ( temp.size() == nums.length ) {
            if ( !list.contains(temp) )
            list.add(new ArrayList(temp));
            return;
        }
        for (int i=0;i<nums.length;i++) {
            if ( b[i] ) continue;
            b[i] = true;
            temp.add(nums[i]);
            dfs(nums,b,temp);
            temp.remove( temp.size() - 1 );
            b[i] = false;
        }
    }
}