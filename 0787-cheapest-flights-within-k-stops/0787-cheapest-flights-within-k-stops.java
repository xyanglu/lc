class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] arr = new int[n];
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[src] = 0;
        
        while ( k + 1 > 0 ) {
            int[] temp = Arrays.copyOfRange(arr,0,arr.length);
            for (int[] f : flights) {
                if ( arr[f[0]] == Integer.MAX_VALUE ) continue;
                if ( arr[f[0]] + f[2] < temp[f[1]] )
                    temp[f[1]] =  arr[f[0]] + f[2];
            }
            
            arr = temp;
            k--;
        }
        
        
        return arr[dst] == Integer.MAX_VALUE ? -1 : arr[dst];
    }
}