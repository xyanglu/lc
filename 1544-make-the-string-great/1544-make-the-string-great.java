class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0 ;
        while ( i < sb.length() - 1 )
        {
            if ( sb.charAt(i) == (char) (sb.charAt(i+1) + ('A'-'a') ) || sb.charAt(i) == (char) (sb.charAt(i+1) - ('A'-'a') ) )
            {
                sb = new StringBuilder(sb.substring(0,i) + sb.substring(i+2,sb.length()));
                i=0;
                //System.out.println(sb.toString());
            }
            else
                i++;
        }
        return sb.toString();
    }
}