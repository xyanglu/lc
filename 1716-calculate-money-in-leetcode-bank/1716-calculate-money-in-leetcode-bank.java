class Solution {
    public int totalMoney(int n) {
        int mon = 1;
        int rc = 0;
        int i = 0;
        
        while ( i < n ) {
            for (int j=i%7;j<7;j++) {
                if ( i + j == n ) return rc;
                rc += mon + j;
                //System.out.println(j);
            }
            i+=7;
            mon++;
        }
        
        return rc;
    }
}