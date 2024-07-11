class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack();
        for ( char c : s.toCharArray() ) {
            if ( c == ')' ) {
                StringBuilder temp = new StringBuilder();
                while ( stack.peek() != '(' )
                    temp.append(stack.pop());
                stack.pop();
                for ( char d : temp.toString().toCharArray() )
                    stack.add(d);
            }
            else
                stack.add(c);
            
        }
        
        while ( !stack.isEmpty() )
            sb.insert(0,stack.pop());
        
        return sb.toString();
        
        
    }
}