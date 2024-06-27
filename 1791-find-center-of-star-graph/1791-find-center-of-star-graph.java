class Solution {
    public int findCenter(int[][] edges) {
        int[] arr = new int[edges.length+2];
        for (int[] e : edges)
        {
            arr[e[0]]++;
            arr[e[1]]++;
        }
        for (int i=1;i<arr.length;i++)
            if ( arr[i] == edges.length )
                return i;
        
        
        return -1;
    }
}