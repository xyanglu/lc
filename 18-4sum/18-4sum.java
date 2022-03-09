class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList();
        dfs(nums,list,new ArrayList(), target, 0,0,4);
        return list;
    }
    void dfs(int[] nums, List<List<Integer>> list, List<Integer> temp, int target, int sum, int i, int k) {
        if ( k == 2 ) {
            int lo = i , hi = nums.length -1; 
            while ( lo < hi ) {
                int val = nums[lo] + nums[hi];
                if ( target == sum + val ) {
                    temp.add(nums[lo]);
                    temp.add(nums[hi]);
                    list.add(new ArrayList(temp));
                    temp.remove(temp.size()-1);
                    temp.remove(temp.size()-1);
                    while ( lo + 1 < nums.length && nums[lo] == nums[lo+1] ) lo++;
                    while ( hi > lo && nums[hi] == nums[hi-1] ) hi--;
                    lo++;
                    hi--;
                }
                else if ( val + sum < target ) 
                    lo++;
                else
                    hi--;
            }
        }
        else {
            for (i=i;i<nums.length;i++) {
                int val = nums[i];
                temp.add(nums[i]);
                dfs(nums,list,temp, target, sum + val,i+1,k-1);
                temp.remove(temp.size()-1);
                while ( i + 1 < nums.length && nums[i] == nums[i+1] ) i++;
            }
        }
    }
}