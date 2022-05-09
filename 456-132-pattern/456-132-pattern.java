class Solution {
    public boolean find132pattern(int[] nums) {
        Queue<int[]> queue = new PriorityQueue<>( (a,b) -> a[0] - b[0]);
        //Stack<Integer> queue = new Stack();
        int min = Integer.MAX_VALUE;
        
        for ( int n : nums) {
            while ( !queue.isEmpty() && n >= queue.peek()[0]  )
                queue.poll();
            if ( !queue.isEmpty() && queue.peek()[1] < n ) 
            {
                System.out.println( queue.peek() + " " + min + " " +n );
                return true;
            }
            queue.add(new int[]{n,min});
            min = Math.min(n,min);
        }
        return false;
        
    }
}