class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> list = new ArrayList();
        dfs(list,new ArrayList(),0,nums);
        list.add(new ArrayList());
        return list;
    }
    void dfs(List<List<Integer>> list, List<Integer> temp, int i, int[] nums) {
        if ( i == nums.length )
            return;
        
        for (i=i;i<nums.length;i++) {
        temp.add(nums[i]);
        list.add(new ArrayList(temp));
        dfs(list,temp,i+1,nums);
        temp.remove(temp.size()-1);
        }
    }
}