class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        while ( path.length() != 0 )
        {
            int index = path.indexOf("/");
            String str = null;
            if ( index != -1 )
                 str = path.substring(0,index); 
            else
                str = path.substring(0,path.length());
                
            System.out.println(str);
            if ( str.equals("..") ) {
                if ( !stack.isEmpty() )
                    stack.pop();
            }
            else if ( str.length() > 0 && !str.equals(".") ) {
                stack.add(str);
            }
            if ( index != -1 )
                path = path.substring(index+1,path.length());
            else
                path = "";
        }
        
        StringBuilder sb = new StringBuilder();
        while ( !stack.isEmpty() ) {
            sb.insert(0,"/" + stack.pop());
            System.out.println(sb);
        }
        return sb.toString() == "" ? "/" : sb.toString();
        
    }
}