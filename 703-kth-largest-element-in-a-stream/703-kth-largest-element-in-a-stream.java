class KthLargest {

    // % % % % %
    //         1
    // 5
    
    // % % % %  %
    //       2
    //
    
    Queue<Integer> leftQueue = new PriorityQueue<>( (a,b) -> b - a );
    Queue<Integer> rightQueue = new PriorityQueue<>();
    int k = 0;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int n : nums)
            rightQueue.add(n);
        while ( !rightQueue.isEmpty() && rightQueue.size() > k )
            leftQueue.add(rightQueue.poll());
    }
    
    public int add(int val) {
        rightQueue.add(val);
        if ( rightQueue.size() > k ) 
            leftQueue.add( rightQueue.poll());
        return rightQueue.peek();
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */