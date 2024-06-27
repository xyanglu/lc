class Solution {
    public int findCenter(int[][] edges) {
        int[] arr = new int[edges.length+2];
        for (int[] e : edges)
        {
            arr[e[0]]++;
            arr[e[1]]++;
            
            if ( arr[e[0]] == edges.length ) return e[0];
            if ( arr[e[1]] == edges.length ) return e[1];
        }
        
        return -1;
    }
}