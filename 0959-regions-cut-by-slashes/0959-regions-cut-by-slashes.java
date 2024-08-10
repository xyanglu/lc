class Solution {
    Set<String> set = new HashSet();
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        String[][] gr = new String[n*3][n*3];
        
        for (int i=0;i<n*3;i++) 
            for (int j=0;j<n*3;j++) 
                gr[i][j] = " ";

        for (int i=0;i<n;i++) {
            String row = grid[i];
            for (int j=0;j<row.length();j++) {
                if ( row.charAt(j)=='/' ) {
                    gr[i*3][j*3+2] = "/";
                    gr[i*3+1][j*3+1] = "/";
                    gr[i*3+2][j*3] = "/";
                }
                else if ( row.charAt(j)=='\\' ) {
                    gr[i*3][j*3] = "\\";
                    gr[i*3+1][j*3+1] = "\\";
                    gr[i*3+2][j*3+2] = "\\";                       
                }
            }
                            }
        
        int rc = 0;
        // for ( int i=0;i<gr.length;i++)
        //     System.out.println(Arrays.toString(gr[i]));
        
        for (int i=0;i<n*3;i++) 
            for (int j=0;j<n*3;j++) 
                if ( gr[i][j].equals(" ") && !set.contains(i+" "+j) ) {
                    dfs(gr,i,j);
                    rc++;
                }
        return rc;
    }
    void dfs(String[][] gr, int i, int j) {
        if ( i < 0 || j < 0 || i == gr.length || j == gr[i].length || set.contains(i+" "+j) || gr[i][j].equals("/") || gr[i][j].equals("\\")) return;
        set.add(i+" "+j);
        dfs(gr,i-1,j);
        dfs(gr,i+1,j);
        dfs(gr,i,j-1);
        dfs(gr,i,j+1);
    }                                   
}