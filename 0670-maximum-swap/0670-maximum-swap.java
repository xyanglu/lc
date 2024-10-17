class Solution {
    public int maximumSwap(int num) {
        StringBuilder sb = new StringBuilder( String.valueOf(num) );
        Map<Character,Integer> map = new HashMap();
        int n = sb.length();
        for (int i=n-1;i>0&&map.size()<9;i--) {
            char c = sb.charAt(i);
            if ( !map.containsKey(c) && c >= '1' )
                map.put(c,i);
        }
        Queue<Map.Entry<Character,Integer>> queue = new PriorityQueue<>( (a,b) -> b.getKey() - a.getKey());
        queue.addAll(map.entrySet());
        
        for (int i=0;i<n;i++) {
            char c = sb.charAt(i);
            while ( !queue.isEmpty() && i >= queue.peek().getValue() )
                queue.poll();
            
            if ( !queue.isEmpty() && c < queue.peek().getKey() )
            {
                sb.setCharAt( i , queue.peek().getKey() );
                sb.setCharAt( queue.peek().getValue(), c);
                break;
            }
        }
        
        return Integer.parseInt( sb.toString() );
    }
}