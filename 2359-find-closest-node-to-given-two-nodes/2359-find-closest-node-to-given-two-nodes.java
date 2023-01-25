class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] arr1 = new int[edges.length];
        int[] arr2 = new int[edges.length];
        Arrays.fill(arr1,-1);
        Arrays.fill(arr2,-1);
        
//         for (int i=0;i<edges.length;i++)
//             System.out.print(i+"\t");
//         System.out.println();
//                 for (int i=0;i<edges.length;i++)

//         System.out.print(edges[i]+"\t");
//                 System.out.println();

        
                //System.out.println(node1);

        dfs(arr1,node1,edges);
                //System.out.println(node2);

        dfs(arr2,node2,edges);
        
        int max = Integer.MAX_VALUE;
        int index = -1;
        
        for (int i=0;i<arr1.length;i++)
            if ( arr1[i] != -1 && arr2[i] != -1 ) {
                if ( Math.max(arr1[i],arr2[i]) < max ) {
                    max = Math.max(arr1[i],arr2[i]);
                    index = i;
                }
            }
        
        return index;
    }
    void dfs(int[] arr, int n, int[] edges) {
        int steps = 0;
        
        while ( n != -1 )
        {
            //System.out.println(n+" "+steps);
                        if ( arr[n] != - 1 ) return;

            arr[n] = steps++;
            n = edges[n];
        }
    }
    
}