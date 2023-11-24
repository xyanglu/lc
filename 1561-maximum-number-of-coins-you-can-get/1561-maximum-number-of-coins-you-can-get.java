class Solution {
    public int maxCoins(int[] piles) {
        int rc = 0;
        List<Integer> list = new ArrayList();
        for (int n : piles)
            list.add(n);
        Collections.sort(list);
        Deque<Integer> queue = new ArrayDeque<Integer>(list);
        //System.out.println(queue);
        while ( !queue.isEmpty()) {
            int v = queue.pollLast();
            ///System.out.println(v);
            v = queue.pollLast();
            //System.out.println(v);
            rc += v;
            v = queue.poll();
            //System.out.println(v);
            
        }
        return rc;
    }
}