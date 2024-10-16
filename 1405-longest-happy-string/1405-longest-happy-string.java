class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();

        Queue<int[]> queue = new PriorityQueue<>( (A,B) -> B[1] - A[1] );
        int prev = -1;
        
        if ( a>0)
        queue.add(new int[]{0,a});
                if ( b>0)
        queue.add(new int[]{1,b});
            if ( c>0)
        queue.add(new int[]{2,c});

        while ( !queue.isEmpty() ) {
            int[] q = queue.poll();
            if ( q[1] == 0 ) continue;
            int[] temp = null;
            int val = Math.min(q[1],2);
            if ( q[0] == prev && !queue.isEmpty() ) {
                temp = q;
                q = queue.poll();
                val = 1;
            }
            else if ( q[0] == prev )
                break;
            prev = q[0];
            for (int i=0;i<val;i++)
                sb.append( (char) (q[0]+'a'));
            // System.out.println(q[0]+" "+val+" "+sb+" "+prev);
            if ( q[1] - val > 0 )
                queue.add(new int[]{q[0],q[1]-val});
            if ( temp!=null )
                queue.add(temp);
        }
        
        return sb.toString();
    }
}