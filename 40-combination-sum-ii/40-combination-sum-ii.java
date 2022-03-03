class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> list = new HashSet();
        dfs(list,candidates,target,new ArrayList(),0,0);
        return new ArrayList(list);
    }
    void dfs(Set<List<Integer>> list, int[] c, int target, List<Integer> temp, int sum, int i) {
        if ( sum > target) return;
        if ( sum == target ) {
            list.add(new ArrayList(temp));
            return;
        }
        int j = i;
        for (i=i;i<c.length;i++)
        {
            if ( i > j && c[i] == c[i-1] ) continue;
            temp.add(c[i]);
            dfs(list,c,target,temp,sum+c[i],i+1); 
            temp.remove(temp.size()-1);

        }  
    }
}