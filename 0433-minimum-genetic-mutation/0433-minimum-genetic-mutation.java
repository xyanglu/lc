class Solution {
    public int minMutation(String start, String end, String[] bank) {
        int steps = 0;
        Set<String> set = new HashSet();
        
        Set<String> banks = new HashSet();
        for ( String b : bank) 
            banks.add(b);
        
        
        Queue<String> queue = new LinkedList();
        queue.add(start);
        
        while ( !queue.isEmpty() ) {
            int size = queue.size();
            for (int i=0;i<size;i++) {
                String s = queue.poll();
                if ( set.contains(s) ) continue;
                if ( end.equals(s) ) return steps;
                //System.out.println(s);
                set.add(s);
                for (int j=0;j<s.length();j++) {
                    //System.out.println(j);
                    StringBuilder sb = new StringBuilder(s);
                        sb.setCharAt(j,'T');
                        if ( banks.contains(sb.toString()))
                            queue.add(sb.toString());

                        sb.setCharAt(j,'G');
                        if ( banks.contains(sb.toString()))
                            queue.add(sb.toString());
 
                        sb.setCharAt(j,'C');
                        if ( banks.contains(sb.toString()))
                            queue.add(sb.toString());

                        sb.setCharAt(j,'A');
                        if ( banks.contains(sb.toString()))
                            queue.add(sb.toString());
                    
                }
            }
            steps++;
            
        }
        
        
        return -1;
    }
}