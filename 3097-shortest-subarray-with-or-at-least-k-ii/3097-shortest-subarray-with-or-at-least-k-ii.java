class Solution {
    public int minimumSubarrayLength(int[] nums, int m) {
        long min = Long.MAX_VALUE;
        int k = 0;
        int bit = 32;
        int[] bits = new int[bit];
        
        for (int i=0;i<nums.length;i++) {

            for (int j=0;j<bit;j++)
                 if ( (nums[i] & (1<<j)) == 1 << j )
                        bits[j]++;
            
            long cur = 0;
            for (int j=0;j<bit;j++)
                if ( bits[j] > 0 )
                    cur += ( 1 << j );
            
            while ( cur >= m && k <= i ) {
                // System.out.println(cur+" "+i+" "+k+" "+Arrays.toString(bits));
                min = Math.min(min,i-k+1);
                
                for (int j=0;j<bit;j++)
                    if ( (nums[k] & (1<<j)) == 1 << j )
                        bits[j]--;
                
                k++;
                
                cur = 0;
                for (int j=0;j<bit;j++)
                    if ( bits[j] > 0 )
                        cur += ( 1 << j );
            }
        }
        
        return min == Long.MAX_VALUE ? -1 : (int) min;
    }
}