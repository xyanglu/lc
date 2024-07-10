class Solution {
    public int minOperations(String[] logs) {
        int rc = 0;
        for (String l : logs)
        {
            if ( l.equals("../") )
            {
                if ( rc > 0 ) rc--;
            }
            else if ( l.equals("./") ) continue;
            else
                rc++;
        }
        return rc;
    }
}