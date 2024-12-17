class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        StringBuilder sb = new StringBuilder();
        
        Map<Character,Integer> map = new HashMap();
        for ( char c : s.toCharArray() ) 
            map.put(c,map.getOrDefault(c,0)+1);
        
        char prev = '#';
        Queue<Map.Entry<Character,Integer>> queue = new PriorityQueue<>( (a,b) -> b.getKey() - a.getKey() );
        queue.addAll(map.entrySet());
        
        while ( !queue.isEmpty() ) {
            Map.Entry<Character,Integer> entry = queue.poll();
            int val = entry.getValue();
            if ( val > repeatLimit ) {
                for (int i=0;i<repeatLimit;i++)
                    sb.append(entry.getKey());
                entry.setValue( entry.getValue() - repeatLimit);
                if ( entry.getValue() > 0 && queue.isEmpty() ) break;
                Map.Entry<Character,Integer> temp = queue.poll();
                sb.append(temp.getKey());
                temp.setValue(temp.getValue()-1);
                if ( temp.getValue() > 0 )
                    queue.add(temp);
                queue.add(entry);
            }
            else
                for (int i=0;i<val;i++)
                    sb.append(entry.getKey());
        }
        
        return sb.toString();
    }
}