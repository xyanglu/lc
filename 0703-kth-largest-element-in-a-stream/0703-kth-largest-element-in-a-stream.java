class KthLargest {

    List<Integer> list = new ArrayList();
    int k = 0;
    public KthLargest(int k, int[] nums) {
        for (int num : nums)
        list.add(num);
        Collections.sort(list,Collections.reverseOrder());
        this.k = k;
    }
    
    public int add(int val) {
        
        int l = 0;
        int r = list.size() - 1;
        int prev = 0;
        
        while ( l <= r ) {
            int m = (l+r);
            if ( val >= list.get(m)  ) {
                r = m - 1;
                prev = m;
            }
            else {
                l = m+1;
                prev = l;
            }
        }
        
        list.add(prev,val);
        return list.get(k-1);
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */