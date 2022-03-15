class Solution {
    public String minRemoveToMakeValid(String s) {
        int cur = 0;
        
        StringBuilder sb = new StringBuilder();
        for ( char c : s.toCharArray() )
            if ( c == '(') {
                cur++;
                sb.append(c);
            }
            else if ( c == ')') {
                if ( cur == 0 ) 
                    continue;
                else {
                    cur--;
                sb.append(c);
                }
            }
        else
            sb.append(c);
        
        cur = 0;
        for (int i=sb.length()-1;i>=0;i--)
        {
            char c = sb.charAt(i);
            if ( c == ')')
                cur++;
            else if ( c == '(' ) {
                if ( cur == 0 )
sb.deleteCharAt(i);
                else 
                    cur--;
            }
        }
        
        return sb.toString();
    }
}