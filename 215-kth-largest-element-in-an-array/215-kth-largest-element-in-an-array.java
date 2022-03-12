class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>( (a,b) -> b - a );
        for (int n : nums)
            queue.add(n);
        while ( k-- > 1 )
            queue.poll();
        return queue.poll();
    }
}