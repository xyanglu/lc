class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
    Queue<double[]> queue = new PriorityQueue<double[]>((a, b) -> Double.compare(a[0]/a[1], b[0]/b[1]));
        for (int i=0;i<arr.length;i++)
            for (int j=i+1;j<arr.length;j++)
                queue.add(new double[]{(double)arr[i],(double)arr[j]});
    
         while ( k-- > 1 ) {
             // System.out.println(Arrays.toString(queue.peek()));
             queue.poll();
         }
         
         return new int[]{ (int)queue.peek()[0], (int) queue.peek()[1] };
    }
}