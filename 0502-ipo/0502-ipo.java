class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {        
        Queue<int[]> queue1 = new PriorityQueue<>( (a,b) -> a[1] - b[1] );
        for (int i=0;i<profits.length;i++)
            queue1.add(new int[]{profits[i],capital[i]});
        
        Queue<int[]> queue2 = new PriorityQueue<>( (a,b) ->  b[0] - a[0] );
                                
        while ( k-- > 0 ) {
            
            while ( !queue1.isEmpty() && queue1.peek()[1] <= w )
                queue2.add( queue1.poll());
            
            if ( !queue2.isEmpty() )
            w+= queue2.poll()[0];
        }
        return w;
    }
}