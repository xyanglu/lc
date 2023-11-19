class Solution {
    public int reductionOperations(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int n : nums)
            set.add(n);
        
        Queue<Integer> queue = new PriorityQueue<>( (a,b)-> b-a);
        for (int n : set)
            queue.add(n);
        
        Map<Integer,Integer> map = new HashMap();
        for (int n : nums)
            map.put(n,map.getOrDefault(n,0)+1);
        
        int rc = 0;
        
        while ( queue.size() != 1 ) { 
            int largest = map.get(queue.poll());
            int next = map.get(queue.peek());
            map.put(queue.peek(),next+largest);
            rc += largest;
        }
        
        
        return rc;
        
        
    }
}  