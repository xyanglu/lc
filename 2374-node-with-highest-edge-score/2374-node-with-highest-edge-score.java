class Solution {
    public int edgeScore(int[] edges) {
        Long[] n = new Long[100000];
        Arrays.fill(n,(long) 0);
        long max = 0;
        for (int i=0;i<edges.length;i++) {
            n[edges[i]]+=i;
            max = Math.max(n[edges[i]],max);
        }
        
        
        for (int i=0;i<n.length;i++)
            if ( max == n[i] )
                return i;
        return 0;
    }
}