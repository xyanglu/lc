class Solution {
    public int minGroups(int[][] intervals) {
        Queue<Integer> q1 = new PriorityQueue();
        Queue<Integer> q2 = new PriorityQueue();
        
        for (int[] i : intervals)
        {
            q1.add(i[0]);
            q2.add(i[1]);
        }
        
        int rc = 0;
        int prev = 0;
        while ( !q1.isEmpty() ) {
            int q = q1.poll();
            while ( !q2.isEmpty() && q2.peek() < q ) { 
                q2.poll();
                prev--;
            }
            prev++;
            rc = Math.max(rc,prev);
            
        }
        
        return rc;
        
        
    }
}