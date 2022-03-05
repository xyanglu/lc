class Solution {
    public int minMovesToMakePalindrome(String s) {
        int sum = 0;
        StringBuilder sb = new StringBuilder(s);
        int l = 0, r = s.length() - 1;
        while ( l < r ) {
            if ( sb.charAt(l) == sb.charAt(r) )
            {
                l++;
                r--;
                continue;
            }
            int k = r;
            while ( k > l && sb.charAt(l) != sb.charAt(k) ) 
                k--;
            
            if ( k == l )
            {
               char temp = sb.charAt(k);
                sb.setCharAt(k, sb.charAt(k+1));
                sb.setCharAt(k+1, temp);
                sum++;
                continue;
            }
            while ( k < r ) {
                char temp = sb.charAt(k);
                sb.setCharAt(k, sb.charAt(k+1));
                sb.setCharAt(k+1, temp);
                sum++;
                k++;
            }

            l++;
            r--;
        }
        return sum;
    }
}