class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        for (int n : nums)
            map.put(n,map.getOrDefault(n,0)+1);
        
        Queue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>( (a,b) -> b.getValue() - a.getValue() );
        queue.addAll(map.entrySet());
        
        int[] rc = new int[k];
        while (k > 0 ) {
            k--;
            rc[k] = queue.poll().getKey();
        }
        return rc;
    }
}