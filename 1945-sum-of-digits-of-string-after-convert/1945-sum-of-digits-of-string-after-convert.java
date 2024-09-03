class Solution {
    public int getLucky(String s, int k) {
        int sum = 0;
        for ( char c : s.toCharArray() ) {
            int val = c-'a'+1;
            for ( char d : String.valueOf(val).toCharArray() )
                sum += d-'0';
        }        k--;
        
        while ( k-- > 0 ) { 
            int temp = 0;
            for ( char c : String.valueOf(sum).toCharArray() )
                temp += c -'0';
            sum = temp;
        }
        return sum;
    }
}

