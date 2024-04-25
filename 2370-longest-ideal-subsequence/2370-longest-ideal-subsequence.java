class Solution {
    public int longestIdealString(String s, int k) {
        int[] rc = new int[26];
        
        int globalMax = 0;
        for ( char c : s.toCharArray() ) {
            int v = c-'a';
            
            int max = 0;
            for (int i=Math.max(0,v-k);i<=Math.min(25,v+k);i++) 
                max = Math.max(rc[i],max);
            
            rc[v] = max + 1;
            globalMax = Math.max(rc[v],globalMax);
        }
        
        return globalMax;
    }
}