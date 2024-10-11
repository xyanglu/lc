class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        Queue<int[]> leave = new PriorityQueue<>( (a,b) -> a[0] - b[0] );
        
        Queue<Integer> queue = new PriorityQueue();
        int n = times.length;
        for (int i=0;i<n;i++)
            queue.add(i);
        int target = times[targetFriend][0];
        
        Arrays.sort(times,(a,b)->a[0]-b[0]);
        
        for (int[] t : times) {
            while ( !leave.isEmpty() && leave.peek()[0] <= t[0] )
                queue.add( leave.poll()[1]);
            if ( t[0] == target ) return queue.poll();
            leave.add( new int[] { t[1], queue.poll()});
        }
        return -1;
        
    }
}