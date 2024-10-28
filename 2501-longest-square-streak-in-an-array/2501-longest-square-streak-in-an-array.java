class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int n : nums)
            set.add(n);
        
        int rc = -1;
        
        for (int n : nums) {
            int sqrt = (int) Math.sqrt(n);
            if ( set.contains(sqrt) && sqrt*sqrt == n) continue;
            int val = 1;
            sqrt = n;
            
            while ( set.contains(sqrt*sqrt) && Math.sqrt(sqrt*sqrt) == sqrt ) {
                // System.out.println(sqrt*sqrt+" "+sqrt);
                sqrt = sqrt*sqrt;
                val++;
            }
            if ( val > 1 ) 
                rc = Math.max(val,rc);
                
            
        }
        
        return rc;
    }
}