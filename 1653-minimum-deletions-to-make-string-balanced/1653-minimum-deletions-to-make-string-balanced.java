class Solution {
    public int minimumDeletions(String s) {
        int a = s.replaceAll("b","").length();
        int b = 0;
        int res = a;
        for ( char c : s.toCharArray() ) {
            if ( c == 'a' ) a--;
            else if ( c == 'b' ) b++;
            res = Math.min(res,a+b);
        }
        
        return res;
        
    }
}