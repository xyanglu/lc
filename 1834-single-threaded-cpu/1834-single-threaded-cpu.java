class Solution {
    public int[] getOrder(int[][] tasks) {
        int[] rc = new int[tasks.length];
        int i = 0;
        int j = 0;
        int time = 0;
        int[][] task = new int[tasks.length][3];
        for (int k=0;k<task.length;k++)
            task[k] = new int[]{k,tasks[k][0],tasks[k][1]};
        
        Arrays.sort(task,(a,b) -> a[1] - b[1]);
        Queue<int[]> queue = new PriorityQueue<>( (a,b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]  );
        
        while ( i < rc.length ) {
            while ( j < task.length && task[j][1] <= time ) {
                queue.add(task[j]);
                j++;
            }
            if ( queue.isEmpty() ) {
                time = task[j][1];
                continue;
            }
            int[] p = queue.poll();
            
            rc[i++] = p[0];
            time += p[2];
            
        }
        
        return rc;
    }
}