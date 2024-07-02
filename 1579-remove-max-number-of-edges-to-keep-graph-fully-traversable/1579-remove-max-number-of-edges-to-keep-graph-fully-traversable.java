class Solution {
    int[][] par;
    int[][] rank;
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        n++;
        par = new int[n][3];
        rank = new int[n][3];
        for (int i=0;i<n;i++) {
            Arrays.fill(par[i],i);
            Arrays.fill(rank[i],1);
        }
        
        int rc = 0;

        for (int[] e : edges)
            if ( e[0] == 3 )
            {
                rc += canRemove(e[1],e[2],1) ? 1 : 0;
                canRemove(e[1],e[2],2);
            }
        
        
        for (int[] e : edges)
            if ( e[0] != 3 && canRemove(e[1],e[2],e[0]) )
                 rc++;
                
        boolean b1 = false, b2 = false;
        
        for (int i=0;i<n;i++) {
            if ( rank[i][1] == n - 1 )
                b1 = true;
            if ( rank[i][2] == n - 1 )
                b2 = true;
        }
        
        if ( !(b1 && b2) ) return -1;
        
        return rc;
    }
    boolean canRemove(int i, int j, int k) {
        int p1 = par(i,k);
        int p2 = par(j,k);
        
        int r1 = rank[p1][k];
        int r2 = rank[p2][k];
        
        if ( p1 == p2 ) 
            return true;
        if ( r1 < r2 ) {
            rank[p2][k] += rank[p1][k];
            par[p1][k] = p2;
        }
        else {
            rank[p1][k] += rank[p2][k];
            par[p2][k] = p1;
        }
        
        return false;
    }
    int par(int i, int k) {
        while ( i != par[i][k] )
            i = par[i][k];
        return i;
    }
}