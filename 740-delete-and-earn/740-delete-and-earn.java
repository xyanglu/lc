class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for (int n : nums)
            count[n]++;
        
        int take = 0;
        int skip = 0;
        for (int i=1;i<10001;i++)
        {
            int takei = count[i] * i + skip;
            skip = take;
            take = Math.max(takei,skip);
            
        }
        
        
        
        return take;
    }
}