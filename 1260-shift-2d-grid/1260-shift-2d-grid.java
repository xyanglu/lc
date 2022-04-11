class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int len = grid.length * grid[0].length;
        k = k % len;
        List<Integer> l = new ArrayList();
        for (int[] g : grid) 
            for (int v : g)
                l.add(v);
        
        while ( k-- > 0 )
            l.add(0,l.remove(len-1));
        
        List<List<Integer>> list = new ArrayList();
        int size = grid[0].length;
        for (int i=0;i<grid.length;i++)
        {
            List<Integer> temp = new ArrayList();
            for (int j=0;j<size;j++)
                temp.add( l.get(i*size + j) );
            list.add(temp);
        }
        
        return list;
    }
}