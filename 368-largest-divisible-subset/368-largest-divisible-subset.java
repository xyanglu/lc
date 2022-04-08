class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList();
        
        for (int i=0;i<nums.length;i++) {
            List<Integer> temp = new ArrayList();
            List<Integer> maxPrev = new ArrayList();
            for (int j=0;j<i;j++)
            {
                if ( nums[j] % nums[i] == 0 || nums[i] % nums[j] == 0 )
                    if ( lists.get(j).size() > maxPrev.size() )
                        maxPrev = lists.get(j);
            }
            temp.addAll(maxPrev);
            temp.add(nums[i]);
            lists.add(temp);
        }
        
        int max = 0;
        for (int i=0;i<nums.length;i++)
            if ( lists.get(i).size() > lists.get(max).size() )
                max = i;
        return lists.get(max);
        
    }
}