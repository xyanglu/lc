class Solution {
    int maxX = 0;
    int maxY = 0;
    public int[][] findFarmland(int[][] land) {
        List<int[]> list = new ArrayList();
        for (int i=0;i<land.length;i++)
            for (int j=0;j<land[0].length;j++) 
                if ( land[i][j] == 1 )
                {
                    maxX = 0;
                    maxY = 0;
                    dfs(land,i,j);
                    list.add(new int[]{i,j,maxX,maxY});
                }     
        int[][] rc = new int[list.size()][4];
        
        for (int i=0;i<list.size();i++)
            rc[i] = list.get(i);      
        
        return rc;
    }
    void dfs(int[][] land, int i, int j) {
        if ( i < 0 || j < 0 || land.length == i || land[0].length == j || land[i][j] == 0 ) return;
        maxX = Math.max(i,maxX);
        maxY = Math.max(j,maxY);
        land[i][j] = 0;
        dfs(land,i-1,j);
        dfs(land,i+1,j);
        dfs(land,i,j-1);
        dfs(land,i,j+1);
        
        
    }
}