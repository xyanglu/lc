class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0, j = 0;
        Stack<Integer> stack = new Stack();
        while ( j < popped.length ) {
            if ( !stack.isEmpty() && stack.peek() == popped[j] ) {
                stack.pop();
                j++;
                continue;
            }
            while ( i < pushed.length && pushed[i] != popped[j] ) 
                stack.add ( pushed[i++] );
            if ( i < pushed.length )
                stack.add( pushed[i++]);
            if ( i == pushed.length && stack.peek() != popped[j] ) return false;
            

        }
        return true;
    }
}