class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet();
        for ( String d : deadends)
            set.add(d);
        
        Queue<String> queue = new LinkedList();
        queue.add("0000");
        
        int t = 0;
        while ( !queue.isEmpty() ) {
            
            int size = queue.size();
            
            for (int i=0;i<size;i++) {   
                StringBuilder sb = new StringBuilder(queue.poll());
                if ( set.contains(sb.toString())) continue;
                if ( sb.toString().equals(target)) return t;
                // System.out.println(sb.toString());
                set.add(sb.toString());
                
                for (int j=0;j<4;j++) {
                char c = sb.charAt(j);
                //up
                sb.setCharAt(j, c=='9'?'0':(char)(c+1));
                queue.add(sb.toString());
                
                //down
                sb.setCharAt(j, c=='0'?'9':(char)(c-1));
                queue.add(sb.toString());
                
                sb.setCharAt(j,c);
                }
            }
            t++;
        }
        
        
        return -1;
    }
}