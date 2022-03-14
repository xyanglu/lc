class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList();
        
        int max = 0;
        for (int i=heights.length-1;i>=0;i--)
        {
            if ( heights[i] > max )
            {
                list.add(i);
                max = heights[i];
            }
        }
        
        int[] rc = new int[list.size()];
        for (int i=list.size()-1;i>=0;i--)
            rc[list.size() - 1 - i] = list.get(i);
        return rc;
    }
}