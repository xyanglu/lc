class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int[][] p = new int[heights.length][2];
        for (int i=0;i<p.length;i++) {
            p[i][0] = i;
            p[i][1] = heights[i];
        }
        Arrays.sort( p, (a,b) -> b[1] - a[1] );
//         for (int[] pee : p)
//          System.out.println(Arrays.toString(pee));
        
        String[] rc = new String[p.length];
        for (int i=0;i<rc.length;i++)
            rc[i] = names[p[i][0]];
        return rc;
    }
}