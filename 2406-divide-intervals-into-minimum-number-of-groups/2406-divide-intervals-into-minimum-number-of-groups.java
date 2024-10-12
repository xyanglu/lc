class Solution {
    public int minGroups(int[][] intervals) {
        List<Integer> q1 = new ArrayList();
        List<Integer> q2 = new ArrayList();
        
        for (int[] i : intervals)
        {
            q1.add(i[0]);
            q2.add(i[1]);
        }
        
        Collections.sort(q1);
        Collections.sort(q2);
        
        int i = 0, j =0;
        int rc = 0;
        while ( i < q1.size() ) {

            if ( q1.get(i) <= q2.get(j) )
                i++;
            else
                j++;
            
            rc = Math.max(rc,i - j);
            
        }
        
        return rc;
        
        
    }
}