class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int total = 0;
        Queue<Integer> queue = new PriorityQueue<>( (a,b) -> b - a);
        for (int i=0;i<costs.length;i++)
        {
            total += costs[i][0];
            queue.add(costs[i][0]-costs[i][1]);
        }
        
        for (int i=0;i<costs.length/2;i++)
            total -= queue.poll();

        return total;
            
    }
}