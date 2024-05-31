class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int n : nums)
            xor ^= n;
        
        int min = 1;
        while ( (xor & min) != min ) 
            min = min << 1;
        
        int a = 0, b = 0;
        for (int n : nums) {
            if ( (n & min) == min )
                a ^= n;
            else
                b ^= n;
        }
        return new int[]{a,b};
    }
}