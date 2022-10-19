class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap();
        Queue<Map.Entry<String,Integer>> queue = new PriorityQueue<>( (a,b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue() );
        
        for (String w : words)
            map.put(w,map.getOrDefault(w,0)+1);
        
        queue.addAll(map.entrySet());
        
        List<String> list = new ArrayList();
        
        while ( k-->0)
            list.add(queue.poll().getKey());
        
        
        return list;
    }
}