class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
    
        Stack<Character> stack = new Stack();
        for ( char c : s.toCharArray() ) {
            if ( !stack.isEmpty() && c == stack.peek() )
            {
                stack.pop();
                continue;
            }
            stack.add(c);
        }
        
        while ( !stack.isEmpty() )
            sb.append(stack.pop());
        
        return sb.reverse().toString();
    }
}