class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] arr = new int[n];
        for (int[] e : edges)
            arr[e[1]]++;
        
        int b = -1;
        for (int i=0;i<n;i++)
        {
            if ( b != -1 && arr[i] == 0 ) return -1;
            if ( arr[i] == 0 ) b = i;
        }
        return b;
        
    }
}