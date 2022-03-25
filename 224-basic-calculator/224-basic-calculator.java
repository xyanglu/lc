class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        int cur=0,sign=1,output=0;
        for ( char c : s.toCharArray() ) {
            if ( Character.isDigit(c) )
                cur = cur*10 + (int) (c - '0');
            else if ( c == '+') {
                output += cur*sign;
                cur = 0;
                sign = 1;
            }
            else if ( c == '-') {
                output+= cur*sign;
                cur = 0;
                sign = -1;
            }
            else if ( c == '(') {
                stack.add(output);
                stack.add(sign);
                sign = 1;
                output = 0;
            }
            else if ( c == ')') {
                output += sign*cur;
                output *= stack.pop();
                output += stack.pop();
                cur = 0;
            }
        }
        return output + cur*sign;
    }
}