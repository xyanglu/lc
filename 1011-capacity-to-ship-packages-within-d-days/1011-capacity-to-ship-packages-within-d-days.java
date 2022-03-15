class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = 0;
        int hi = 0;
        for (int w : weights) {
            lo = Math.max(lo,w);
            hi +=w;
        }
        
        if ( days == 1 ) return hi;
        
        while (lo < hi)
        {
            int mid = (lo + hi)/2;
            if ( canFinish(weights,mid,days) )
                hi = mid;
            else
                lo = mid + 1;
        }   
        return lo;
    }
    boolean canFinish(int[] weights, int speed, int days) {
        int d = 0;
        int s = 0;
        int i = 0;
        
        while (i < weights.length ) {
            if ( weights[i] > speed ) return false;
            while (i < weights.length && s + weights[i] <= speed) {
                s += weights[i];
                i++;
            }
            s = 0;
            d++;
        }
        
        
        return d <= days;
    }
}