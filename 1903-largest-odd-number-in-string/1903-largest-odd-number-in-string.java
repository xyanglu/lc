class Solution {
    public String largestOddNumber(String num) {
        while ( num.length() > 0 && (int) num.charAt(num.length()-1) % 2 == 0 )
            num = num.substring(0,num.length()-1);
        return num;
    
    }
}