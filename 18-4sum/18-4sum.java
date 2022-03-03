class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return dfs(nums,target,4,0);
    }
    List<List<Integer>> dfs(int[] nums, int target, int k, int i) {
        List<List<Integer>> rc = new ArrayList<>();
        if ( i >= nums.length ) return rc;
        if ( k == 2 ) {
           int l = i , r = nums.length-1;
            while ( l < r ) {
                int val = nums[l] + nums[r];
                if ( val == target )
                {
                    List<Integer> temp = new ArrayList();
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    rc.add(temp);
                    while ( l<r && nums[l] == nums[l+1] ) l++;
                    while ( l<r && nums[r] == nums[r-1] ) r--;
                    l++;
                    r--;
                }
                else if ( val < target)
                    l++;
                else 
                    r--;
            }
        }
        else {
            for (int j=i;j<nums.length;j++) {
                List<List<Integer>> list = dfs(nums,target-nums[j],k-1,j+1);
                if ( list!=null ) {
                    for ( List<Integer> l : list )
                        l.add(0,nums[j]);
                rc.addAll(list);
                }
                while ( j+1 < nums.length && nums[j] == nums[j+1] ) j++;
            }
        }
        return rc;
    }
}