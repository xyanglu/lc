class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>( (a,b) -> b - a );
        for (int s : stones)
            queue.add(s);
        
        while ( !queue.isEmpty() && queue.size() != 1 ) {
            int a = queue.poll();
            int b = queue.poll();
            if ( a - b != 0 )
                queue.add(a-b);
            System.out.println(a + " "+b);
        }
        
        return queue.isEmpty() ? 0 : queue.poll();
        
    }
}