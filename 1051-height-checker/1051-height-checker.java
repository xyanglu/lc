class Solution {
    public int heightChecker(int[] heights) {
        int[] h = new int[heights.length];
        for (int i=0;i<heights.length;i++)
            h[i] = heights[i];
        Arrays.sort(h);
        int i = 0;
        int rc = 0;
        while ( i < heights.length ) {
            rc += (heights[i] == h[i] ? 0 : 1);
            i++;
        }
        return rc;
    }
}