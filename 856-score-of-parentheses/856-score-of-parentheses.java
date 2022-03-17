class Solution {
    public int scoreOfParentheses(String s) {
       Stack<Integer> stack = new Stack();
        int i = 0;
        int sum = 0;
        while ( i < s.length() )
        {
            if ( s.charAt(i) == '(' ) {
                stack.add(0);
                        i++;
            }
            else {
                                sum += Math.pow(2,stack.size()-1);

            while ( i < s.length() && s.charAt(i) == ')' && !stack.isEmpty() ) {
                i++;
                stack.pop();
            }
            }
        }
        return sum;
    }
}