class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] arr = new int[n];
        
        for (int i=0;i<arr.length;i++) 
            if ( arr[i] == 0 && !dfs(graph,i,1,arr)) 
                return false;
        
        return true;
    }
    boolean dfs(int[][] graph, int i, int color, int[] arr ) {
        if ( arr[i] != 0 )
            return color == arr[i];
        
        arr[i] = color;
        
        for (int neigh : graph[i])
            if ( !dfs(graph,neigh,-color,arr) )
                return false;
        
        return true;
    }
}