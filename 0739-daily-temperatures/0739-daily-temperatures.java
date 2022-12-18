class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] next = new int[101];
        int[] rc = new int[temperatures.length];
        
        for (int i=rc.length-1;i>=0;i--) {
            int temp = temperatures[i];
            
            int min = Integer.MAX_VALUE;
            for (int j=temp+1;j<=100;j++)
                if ( next[j] != 0 )
                    min = Math.min( next[j] - i, min);
            
            if ( min != Integer.MAX_VALUE )
                rc[i] = min;
            
            next[temp] = i;
        }
        
        
        return rc;
        
        
    }
}