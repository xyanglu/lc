class NumArray {

            Map<Integer,Integer> map = new HashMap();
    
    public NumArray(int[] nums) {
        int sum = 0;
        for (int i=0;i<nums.length;i++)
            map.put(i,sum+=nums[i]);
    }
    
    public int sumRange(int left, int right) {
        if ( left!=0)
        return map.get(right) - map.get(left - 1) ;
        else
            return map.get(right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */