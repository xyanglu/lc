class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int r, int c) {
        int[][] d = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        Set<String> set = new HashSet();
        int p = 3;
        
        int[][] rc = new int[rows*cols][2];
        rc[0] = new int[]{r,c};
        set.add(r+" "+c);
        int i = 1;
        
        while ( i < rc.length ) {
            int n = (p + 1) % 4;
            while ( set.contains((r+d[n][0])+" "+ (c+d[n][1])  ))
           {
               r+=d[p][0];
               c+=d[p][1];
                if ( i < rc.length && (r>=0&&c>=0) && (r<rows&&c<cols) )
                   rc[i++]=new int[]{r,c};
                set.add(r+" "+c);
            
           }
            p = (p+1)%4;;
            r+=d[n][0];
            c+=d[n][1];
                if ( i < rc.length && (r>=0&&c>=0) && (r<rows&&c<cols) )
            rc[i++] = new int[]{r,c};
            set.add(r+" "+c);
        }
        
        return rc;
        
    }
}