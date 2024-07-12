import java.util.Stack;

class Solution {
    public int maximumGain(String s, int x, int y) {
        int rc = 0;
        Stack<Character> stack = new Stack<>();
        char firstChar = x > y ? 'a' : 'b';
        char secondChar = x > y ? 'b' : 'a';
        int firstPoints = x > y ? x : y;
        int secondPoints = x > y ? y : x;
        
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == firstChar && c == secondChar) {
                rc += firstPoints;
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        Stack<Character> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        
        while (!tempStack.isEmpty()) {
            char c = tempStack.pop();
            if (!stack.isEmpty() && stack.peek() == secondChar && c == firstChar) {
                rc += secondPoints;
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        return rc;
    }
}
