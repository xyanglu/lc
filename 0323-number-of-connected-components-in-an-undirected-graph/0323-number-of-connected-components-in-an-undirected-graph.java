class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] arr = new int[n];
        int[] rank = new int[n];
        Arrays.fill(rank,1);
        for (int i=0;i<n;i++)
            arr[i] = i;
        
        for (int[] e : edges)
            n -= dfs(e[0],e[1],arr,rank);
        
        return n;
    }
    int dfs(int i, int j, int[] arr, int[] rank) {
        int I = find(i,arr);
        int J = find(j,arr);
        
        if ( rank[I] > rank[J] )
        {
            arr[J] = I;
            rank[I] += rank[J];
        }
        else
        {
            arr[I] = J;
            rank[J] += rank[I];
        }
        
        
        return I == J ? 0 : 1;
    }
    int find(int i, int[] arr) {
        while ( arr[i] != i )
            i = arr[i];
        return i;
    }
}