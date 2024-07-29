class Solution {
    public int numTeams(int[] rating) {
        int[] more = new int[rating.length];
        int[] less = new int[rating.length];
        
        for (int i=0;i<rating.length;i++) {
            int r = rating[i];
            for (int j=i+1;j<rating.length;j++)
                if ( rating[j] > r )
                    more[i]++;
                else if ( rating[j] < r )
                    less[i]++;
        }
        
        int rc = 0;
        
        for (int i=0;i<rating.length;i++) {
            int r = rating[i];
            for (int j=i+1;j<rating.length;j++)
                if ( rating[j] > r )
                    rc += more[j];
                else if ( rating[j] < r )
                    rc += less[j];
        }
        return rc;
        
        
    }
}