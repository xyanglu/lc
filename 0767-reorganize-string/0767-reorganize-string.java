class Solution {
    public String reorganizeString(String s) {
        Queue<int[]> queue = new PriorityQueue<>( (a,b) -> b[1] - a[1] );
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[26];
        for ( char c : s.toCharArray() )
            arr[c-'a']++;
        
        for (int i=0;i<26;i++)
            if ( arr[i] != 0 )
                queue.add(new int[]{i,arr[i]});
        
        while ( queue.size() > 1 ) {
            int[] p = queue.poll();
            int[] q = queue.poll();
            if ( p[1]-1 > 0 )
                queue.add(new int[]{p[0],p[1]-1});
            if ( q[1] - 1 > 0 )
                queue.add(new int[]{q[0],q[1]-1});
            
            sb.append(String.valueOf((char) (p[0]+'a')) + (char) (q[0]+'a'));
        }
        if ( !queue.isEmpty() ) { 
            int[] p = queue.poll();
            if ( p[1] != 1 ) return "";
            sb.append( (char) (p[0]+'a'));
        }
        if ( queue.size() == 0 )
            return sb.toString();
            
        return "";
    }
}