class Solution {
    public double averageWaitingTime(int[][] customers) {
        double sum = 0;
        int count = 0;
        int max = 0;
        
        for (int[] c : customers) {
            max = Math.max(max,c[0]);
            
            sum += max - c[0] + c[1];
            count++;
            max = max + c[1];
        }
        
        return sum / count;
    }
}