class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Queue<int[]> queue = new PriorityQueue<>( (a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for (int i=0;i<mat.length;i++) {
            queue.add( new int[]{i, count(mat[i]) } );
            System.out.println(i + " "+count(mat[i]));
        }
        int[] rc = new int[k];
        for (int i=0;i<k;i++)
            rc[i] = queue.poll()[0];
        
        return rc;
    }
    int count(int[] m) {
        int l = 0, r = m.length - 1;
        while (l<=r) {
            int mid = (l+r)/2;
            if ( m[mid] == 1 )
                l = mid + 1;
            else
                r = mid - 1;
        }
        
        return l;
    }
}