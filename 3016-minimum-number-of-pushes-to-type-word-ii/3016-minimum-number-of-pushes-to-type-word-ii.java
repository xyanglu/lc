class Solution {
    public int minimumPushes(String word) {
        Map<Character,Integer> map = new HashMap();
        int used = 0;
        int res = 0;
        int cur = 1;
        
        Map<Character,Integer> occur = new HashMap();
        for ( char c : word.toCharArray() ) 
            occur.put(c,occur.getOrDefault(c,0)+1);
        Queue<Map.Entry<Character,Integer>> queue = new PriorityQueue<>( (a,b) -> b.getValue() - a.getValue() );
            queue.addAll(occur.entrySet());
        
        while ( !queue.isEmpty() ) {
            char c = queue.peek().getKey();
            if ( used == 8 ) {
                cur++;
                used = 0;
            }
            used++;
            
            res += cur * queue.poll().getValue();
        }
        return res;
    }
}