class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder(s);
        int n = s.length();
        for (int i=2;i<n;i++) {
            if ( sb.charAt(i-2) == sb.charAt(i-1) && sb.charAt(i-1) == sb.charAt(i) ) {
                sb.deleteCharAt(i);
                n--;
                i--;
            }
        }
        

        return sb.toString();
    }
}