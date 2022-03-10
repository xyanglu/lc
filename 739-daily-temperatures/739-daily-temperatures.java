class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> stack = new Stack<>();
    int[] rc = new int[temperatures.length];
        
    for(int i = 0; i < temperatures.length; i++) {
        while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
            int index = stack.pop();
            rc[index] = i - index;
        }
        stack.push(i);
    }
    return rc;
}
}