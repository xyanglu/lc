class Solution {
    public String convertToTitle(int columnNumber) {
        String rc = "";
        int base = 1;
        while ( columnNumber != 0 ) {
            int val = (columnNumber - 1) % 26;
            rc = (char) ('A'+val) + rc;
            columnNumber = (columnNumber-1) / 26;
        }
        
        return rc;
        
    }
}