class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();
        for ( String c : ops )
        {
            if ( c.equals("C") )
                stack.pop();
            else if ( c.equals("D") )
                stack.add( 2 * stack.peek());
            else if ( c.equals("+") )
            {
               int v1 = stack.pop();
                int v2 = stack.pop();
                stack.add(v2);
                stack.add(v1);
                stack.add(v1+v2);
            } 
            else
                stack.add (Integer.parseInt(c));
        }
        
        
        int sum = 0;
        while ( !stack.isEmpty() ) 
            sum += stack.pop();;
        return sum;
    }
}