class Solution {
    public String largestGoodInteger(String num) {
        
        int rc = -1;
        
        for (int i=0;i+3<=num.length();i++) {
            String sub = num.substring(i,i+3);
            if ( sub.length() - sub.replace(""+num.charAt(i),"").length() == 3 ) {
                rc = Math.max(rc,num.charAt(i) - '0');
            }
        }
        
        if ( rc == -1 ) return "";
        
        
        char d = (char) ( rc + '0' );
        
        return "" + d + d + d;
    }
}