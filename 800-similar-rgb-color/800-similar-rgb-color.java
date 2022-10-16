class Solution {
    public String similarRGB(String color) {
        return '#' + create(color.substring(1,3)) + create(color.substring(3,5))+ create(color.substring(5,7)) ;
    }
    String create(String s) {
        char c = s.charAt(0);
        char b = s.charAt(1);
        
        int low = (int) 16*(charToInt(c)-1) + charToInt(c) - 1;
        int mid  = (int) 16*charToInt(c) + charToInt(c);
        int high = (int) 16*(charToInt(c)+1) + charToInt(c) + 1 ;
        
        int val = (int) 16*charToInt(c) + charToInt(b);
        int v = 0;
        if ( Math.abs(low-val) < Math.abs(high-val) && Math.abs(mid-val)< Math.abs(high-val) )
            v = low / 16;
        if ( Math.abs(mid-val) < Math.abs(high-val) && Math.abs(mid-val)< Math.abs(low-val) )
            v = mid / 16;
        if ( Math.abs(high-val) < Math.abs(low-val) && Math.abs(high-val)< Math.abs(mid-val) )
            v = high / 16;
        return String.valueOf( intToChar(v) + ""+ intToChar(v)  );
        
        
    }
    int charToInt(char c) {
        if ( c >= '0' && c<='9' )
            return (int) ( c - '0');
        else
            return (int) ( c - 'a' + 10 );
    }
    char intToChar(int i) {
        if ( i >= 0 && i <= 9 )
            return (char) ( i + '0');
        else
            return (char) ( i - 10 + 'a');
    }
}