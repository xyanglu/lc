class Solution {
    int rc = 0;
    public int countVowelStrings(int n) {
        count(n,0,0);
        return rc;
    }
    void count(int n, int num, int start) {
        if ( n == num )
        {
            rc++;
            return;
        }
        for (int i=start;i<5;i++)
        {
            count(n,num+1,i);
        }
    }
}