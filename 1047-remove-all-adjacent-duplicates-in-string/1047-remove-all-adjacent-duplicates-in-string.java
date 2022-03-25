class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack();
        
        StringBuilder sb = new StringBuilder();
        for ( char c : s.toCharArray() ) {
            if ( !stack.isEmpty() && stack.peek() == c  ) {
                while ( !stack.isEmpty() && stack.peek() == c )
                    stack.pop();
                continue;
            }
            stack.add(c);
        }
        
        while (!stack.isEmpty()) {
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }
}