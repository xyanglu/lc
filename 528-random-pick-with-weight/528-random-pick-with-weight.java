class Solution {

    int total = 0;
    int[] weights;
    public Solution(int[] w) {
        weights = new int[w.length];
        
        for (int i=0;i<w.length;i++)
            weights[i] = total+=w[i];
    }
    
    public int pickIndex() {
        double val = Math.random() * total;
        int i = 0;
        while ( i < weights.length ) {
            if ( val < weights[i] )
                return i;
            i++;
        }
        return i-1;
                
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */