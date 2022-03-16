class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        Stack<Integer> stack = new Stack();
        for (int p : pushed) {
            stack.add(p);
            while ( !stack.isEmpty() && stack.peek() == popped[i] ) {
                i++;
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}