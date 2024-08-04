class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Long> list = new ArrayList();
        for (int i=0;i<n;i++)
            for (int j=i+1;j<=n;j++) 
                list.add(sum(nums,i,j));
            Collections.sort(list);
        // System.out.println(list);
        
        long sum = 0;
                int m = (int) (1e9+7);
        
        for (int i=left-1;i<=right-1;i++)
            sum = (sum + list.get(i) ) % m;
        
        return (int) sum ;
            
    }
    long sum(int[] nums,int i, int j) {
        long sum = 0;
        while ( i < j )
            sum += nums[i++];
        return sum;
    }
}