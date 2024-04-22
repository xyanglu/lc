class Solution {
    public int openLock(String[] deadends, String target) {
        int min = 0;
        Set<String> set = new HashSet();
        for (String d : deadends)
            set.add(d);
        if ( set.contains("0000") ) return -1;
        Queue<String[]> queue = new PriorityQueue<>( (a,b) -> Integer.valueOf(a[1]) - Integer.valueOf(b[1]));
        queue.add(new String[]{"0000","0","0"});
        int max = 0;
        
        while ( !queue.isEmpty() ) {
            String[] p = queue.poll();
            StringBuilder sb = new StringBuilder(p[0]);
            String s = p[0];
            int i = Integer.valueOf(p[2]);
            if ( set.contains(s) || set.contains(i+" "+s) || i == sb.length()  ) continue;
            if ( s.equals(target) ) 
                return Integer.valueOf(p[1]);
            // System.out.println(s+" "+p[1]+" "+p[2]);
            set.add(i+" "+s);
            char c = s.charAt(i);
            queue.add(new String[]{p[0],p[1],String.valueOf(Integer.valueOf(p[2])+1)});
            if ( c == '9' ) {
                sb.setCharAt(i,'0');
                queue.add(new String[]{sb.toString(),String.valueOf(Integer.valueOf(p[1])+1),"0"});
                
                sb.setCharAt(i,'8');
                queue.add(new String[]{sb.toString(),String.valueOf(Integer.valueOf(p[1])+1),"0"});           
            }
                else if ( c == '0' ) {
                sb.setCharAt(i,'1');
                                queue.add(new String[]{sb.toString(),String.valueOf(Integer.valueOf(p[1])+1),"0"});       sb.setCharAt(i,'9');
                queue.add(new String[]{sb.toString(),String.valueOf(Integer.valueOf(p[1])+1),"0"});            }
            else {
                sb.setCharAt(i,(char)(c+1));                queue.add(new String[]{sb.toString(),String.valueOf(Integer.valueOf(p[1])+1),"0"});            
                sb.setCharAt(i,(char)(c-1));
                                queue.add(new String[]{sb.toString(),String.valueOf(Integer.valueOf(p[1])+1),"0"});
            }
        }
        return -1;
    }
}