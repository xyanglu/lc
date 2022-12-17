class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack();
        
        for (int i=tokens.length-1;i>=0;i--) {
            String s = tokens[i];
            stack.add(s);
            while ( stack.size() > 2 ) {
                String a = stack.pop();
                String b = stack.pop();
                String c = stack.pop();

                int A = 0;
                int B = 0;
                try {
                    A = Integer.parseInt(a);
                    B = Integer.parseInt(b);
                    if ( c.length() != 1 || c.compareTo("9")>0 )
                        throw new Exception();
                }
                catch (Exception e) {
                                        stack.add(c);
                    stack.add(b);

                    stack.add(a);
                    break;
                }
                //System.out.println(a+" "+b+' '+c);
                if ( c.equals("+") )
                    stack.add(String.valueOf(A+B));
                if ( c.equals("*"))
                    stack.add(String.valueOf(A*B));
                 if ( c.equals("/"))
                    stack.add(String.valueOf(A/B));
                 if ( c.equals("-"))
                    stack.add(String.valueOf(A-B));
            }
        }
        
        
        return Integer.parseInt(stack.pop());
    }
}   