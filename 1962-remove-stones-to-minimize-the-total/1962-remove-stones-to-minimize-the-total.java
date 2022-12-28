class Solution {
    public int minStoneSum(int[] piles, int k) {
        int sum = 0;
        Queue<Integer> queue = new PriorityQueue<>( (a,b) -> b -a );
        
        for (int p : piles) {
            sum += p;
            queue.add(p);
        }
        
        while ( k-- > 0 )
        {
            int val = queue.poll();
            sum -= val/2;
            queue.add( val - val/2);
        }
        
        return sum;
    }
}