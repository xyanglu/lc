class MedianFinder {
    
    Queue<Integer> maxHeap = new PriorityQueue<>( (a,b) -> b - a );
    Queue<Integer> minHeap = new PriorityQueue<>( (a,b) -> a - b );

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
            maxHeap.add(num);
        if ( minHeap.size() < maxHeap.size() )
            minHeap.add(maxHeap.poll());
        if ( maxHeap.size()>0 &&  maxHeap.peek() > minHeap.peek() ) {
            int temp = maxHeap.poll();
            maxHeap.add(minHeap.poll());
            minHeap.add(temp);
        }
    }
    
    public double findMedian() {
        if ( maxHeap.size() == minHeap.size() )
            return ( maxHeap.peek() + minHeap.peek())/2.0;
        else if ( minHeap.size() > 0 ) 
            return minHeap.peek();
        else
            return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */