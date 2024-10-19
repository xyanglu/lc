class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append('0');
        k--;
        
        while ( n-- > 1 ) {
            StringBuilder temp = new StringBuilder();
            for ( char c : sb.toString().toCharArray() )
                if ( c == '1' )
                    temp.append('0');
            else
                temp.append('1');
            temp.reverse();
            
            sb.append("1");
            sb.append(temp);
            // System.out.println(sb);
        }
        
        return sb.charAt(k);
    }
}