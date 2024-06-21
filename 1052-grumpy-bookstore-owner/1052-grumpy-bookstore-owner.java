class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int max = 0;
        int cur = 0;
        for (int i=0;i<customers.length;i++) 
            cur += customers[i] * (1-grumpy[i]);
        max = Math.max(cur,max);
        
        for (int i=0;i<minutes;i++) 
            if ( grumpy[i] == 1 )
            {
                cur += customers[i];
                max = Math.max(max,cur);
            }
        
        
        for (int i=minutes;i<customers.length;i++) {
            if ( grumpy[i-minutes] == 1 )
                cur -= customers[i-minutes];
            if ( grumpy[i] == 1 )
            {
                cur += customers[i];
                max = Math.max(max,cur);
            }
        }
        
        
        
        return max;
        
    }
}