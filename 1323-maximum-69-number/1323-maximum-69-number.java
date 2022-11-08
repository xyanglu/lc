class Solution {
    public int maximum69Number (int num) {
        String s = String.valueOf(num);
        StringBuilder sb = new StringBuilder(s);
        for ( int i=0;i<sb.length();i++) {
            char c = sb.charAt(i);
            if ( c == '6' ) {
                sb.setCharAt(i,'9');
                return Integer.parseInt(sb.toString());
            }
        }
        return num;
    }
}