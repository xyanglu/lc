class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack();
        for (int i=0;i<arr.length;i++)
        {
            String str = arr[i];
            if ( str.equals("..")) {
                if ( !stack.isEmpty() )
                    stack.pop();
            }
            else if ( str.length() > 0 && !str.equals(".") )
                stack.add(str);
        }
        
        if ( stack.isEmpty() ) return "/";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.insert(0,"/"+stack.pop());
        return sb.toString();
    }
}