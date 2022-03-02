class Solution {
    public int earliestAcq(int[][] logs, int n) {
        int N = n;
        Arrays.sort(logs, (a,b) -> a[0] - b[0]);
        int[] par = new int[n];
        for (int i=0;i<n;i++)
            par[i] = i;
        int[] deg = new int[n];
        
        for (int i=0;i<logs.length;i++) {
            int n1 = logs[i][1];
            int n2 = logs[i][2];
            if ( par[n1] != par[n2] ) {

                while (par[n1] != n1 )
                {
                    n1 = par[n1];
                }
                while (par[n2] != n2 )
                {
                    n2 = par[n2];
                }
                      
                if ( n1 == n2 ) continue;
                
                if ( deg[n1] <= deg[n2]) {
                    deg[n2]++;
                    par[n1] = n2;
                }
                else {
                    deg[n1]++;
                    par[n2] = n1;
                }
                n--;
            }
            if ( n == 1 ) return logs[i][0];
        }
        
        return -1;
    }
}