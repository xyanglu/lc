class Solution {
    public boolean isStrobogrammatic(String num) {
        if ( num.length() == 0 ) return true;
        if ( num.length() == 1)
        {
            if (( num.equals("1") || num.equals("8") || num.equals("0") ))
                return true;
            return false;
        }
        
        String sub = num.substring(1,num.length()-1);
        if ( num.startsWith("1") && num.endsWith("1")) return isStrobogrammatic(sub);
        if ( num.startsWith("6") && num.endsWith("9")) return  isStrobogrammatic(sub);
        if ( num.startsWith("8") && num.endsWith("8")) return  isStrobogrammatic(sub);
        if ( num.startsWith("9") && num.endsWith("6")) return  isStrobogrammatic(sub);
        if ( num.startsWith("0") && num.endsWith("0")) return  isStrobogrammatic(sub);
            
        return false;
    }
}