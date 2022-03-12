class Solution {
    public int minAddToMakeValid(String s) {
        int sum = 0;
        int cur = 0;
        for (char c : s.toCharArray() )
        {
            if ( c == '(')
                cur++;
            if ( c == ')')
                cur--;
            if ( cur < 0 ) 
            {
                cur++;
                sum++;
            }
        }
        return cur + sum;
    }
}