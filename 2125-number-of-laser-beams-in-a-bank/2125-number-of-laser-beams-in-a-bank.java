class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int rc = 0;
        
        for (int i=0;i<bank.length;i++) {
            int cur = bank[i].replace("0","").length();
            if (cur!=0)
            {
                rc += prev * cur;
                prev = cur;
            }
        }
        
        
        
        return rc;
    }
}