class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap();
        for ( char c : s.toCharArray() )
            map.put(c,map.getOrDefault(c,0)+1);
    
        Queue<Map.Entry<Character,Integer>> queue = new PriorityQueue<>( (a,b) -> b.getValue() - a.getValue() );
        queue.addAll(map.entrySet());
        
        StringBuilder sb = new StringBuilder();
        while ( !queue.isEmpty())
        {
            Map.Entry<Character,Integer> entry = queue.poll();
            for (int i=0;i<entry.getValue();i++)
                sb.append(entry.getKey());
            
        }
        return sb.toString();
        
        
    }
}