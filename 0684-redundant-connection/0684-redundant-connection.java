class Solution {
    
    int[] par;
    int[] rank;
    
    public int[] findRedundantConnection(int[][] edges) {
        int[] rc = new int[2];
        
        int n = edges.length+1;
        par = new int[n];
        rank = new int[n];
        for (int i=0;i<n;i++)
            par[i] = i;
        
        for (int[] e : edges)
        {
            int p1 = par(e[0]);
            int p2 = par(e[1]);
            
            int r1 = rank[p1];
            int r2 = rank[p2];
            if ( p1 == p2 ) {
                rc = e;
                continue;
            }
            if ( r1 < r2 ) 
            {
                r2 += r1;
                par[p1] = p2;
            }
            else {
                r1 += r2;
                par[p2] = p1;
            }
        }
        return rc;
    }
    int par(int i) {
        while ( i != par[i] )
            i = par[i];
        return i;
    }
}