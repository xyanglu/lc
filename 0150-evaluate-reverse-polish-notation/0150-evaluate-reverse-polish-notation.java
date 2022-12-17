class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        
        for ( String s : tokens ) {
            if ( isInt(s) ) {
                stack.add(Integer.parseInt(s));
                continue;    
            }
            char c = s.charAt(0);
            int val1 = stack.pop();
            int val2 = stack.pop();
            if ( c == '+')
                stack.add( val1 + val2);
            else if ( c == '*' )
                stack.add(val1*val2);
            else if ( c == '/')
                stack.add(val2/val1);
            else if ( c == '-')
                stack.add(val2-val1);
        }
        
        return stack.pop();
    }
    boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        }
        catch (Exception e) {
            return false;
        }
        
        return true;
    }
}