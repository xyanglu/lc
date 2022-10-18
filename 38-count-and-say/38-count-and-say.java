class Solution {
    public String countAndSay(int n) {
        String s = "1";
        
        for (int i=2;i<=n;i++) {
                    StringBuilder sb = new StringBuilder();
            //System.out.println(s);
                    char d = '#';
                    int count = 0 ;

            for ( char c : s.toCharArray() ) {
                if ( d == '#' || d == c )
                {
                    d = c;
                    count++;
                    continue;
                }
                sb.append(count);
                sb.append(d);
                d = c;
                count = 1;
            }
                           sb.append(count);
                sb.append(d);
            s = sb.toString();
        }
        return s;
    }
}