class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
               int total = 0;
        int[] arr = new int[gas.length];
        for (int i=0;i<gas.length;i++) {
            arr[i] = gas[i] - cost[i];
            total += arr[i];
        }
        
        if ( total < 0 ) return -1;
        
        total = 0;
        int start = 0;
        for (int i=0;i<gas.length;i++)
        {
            total += arr[i];
            if ( total < 0 ) {
                start = i + 1;
                total = 0;
            }
        }
        return start;
    }
}