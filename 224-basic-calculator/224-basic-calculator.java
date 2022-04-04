class Solution {
    public int calculate(String s) {
    
        int output = 0, cur = 0, sign = 1;
        Stack<Integer> stack = new Stack();
        
        for ( char c : s.toCharArray() )
        {
            if ( Character.isDigit(c) )
                cur = cur *10 + (int) (c - '0');
            else if ( c == '+')
            {
                output += cur * sign;
                sign = 1;
                cur = 0;
            }
            else if ( c == '-')
        {
                output += cur * sign;
                sign = -1;
                cur = 0;
            }
            else if ( c == '(' )
            {
                stack.add(output);
                stack.add(sign);
                output = 0;
                sign = 1;
            }
            else if ( c == ')')
            {
                output += cur*sign;
                cur = 0;
                output*=stack.pop();
                output += stack.pop();
            }                
        }
        
        
        return output + cur*sign;
        
        
    }
}