class Solution {
    public int nthUglyNumber(int n) {
        Queue<Long> queue = new PriorityQueue<>();
        queue.add((long)1);
        Set<Long> set = new HashSet();
        while ( n-- > 0 ) {
            long val = queue.poll();
            if ( set.contains(val) ) { n++;
                                     continue;
                                     }
            if ( n == 0 ) return (int) val;
            set.add(val);
            queue.add(val*2);
            queue.add(val*3);
            queue.add(val*5);
        }
        return -1;
    }
}