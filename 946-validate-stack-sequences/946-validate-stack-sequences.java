class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack();
        int i = 0;
        for (int push : pushed ) {
            stack.add(push);
            while ( !stack.isEmpty() && stack.peek() == popped[i] ) {
                i++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}