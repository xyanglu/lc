class Solution {
    public int minCost(String colors, int[] neededTime) {
        int rc = 0;
        
        Stack<Character> stack = new Stack();
        Stack<Integer> stackI = new Stack();
        
        for (int i=0;i<colors.length();i++) {
            char c = colors.charAt(i);
            int v = neededTime[i];
            if ( !stack.isEmpty() && stack.peek() == c ) {
                if ( stackI.peek() < v ) {
                    rc += stackI.pop();
                    stack.pop();
                }
                else {
                    rc += v;
                    continue;
                }
            }
            else if ( !stack.isEmpty() ) 
                stack.pop();
            stack.add(c);
            stackI.add(v);
        }
        
        
        return rc;
    }
}