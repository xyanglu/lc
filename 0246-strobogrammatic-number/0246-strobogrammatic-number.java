class Solution {
    public boolean isStrobogrammatic(String num) {
        //0 1 2 3 4 5 6 7 8 9
        StringBuilder sb = new StringBuilder();
        for (char c : num.toCharArray() )
        {
            if ( c =='3' || c=='4' || c=='5' || c=='7'  ) return false;
            if ( c == '0')
                sb.append('0');
            if ( c == '1')
                sb.append('1');
            if ( c == '6')
                sb.append('9');
            if ( c == '8')
                sb.append('8');
            if ( c == '9')
                sb.append('6');
            
            
        }
        sb.reverse();
        //System.out.println(sb.toString());
        
        return sb.toString().equals(num);
    }
}