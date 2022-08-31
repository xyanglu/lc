class Solution {
            int n = 0;
        int m = 0;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;
        boolean[][] pac = new boolean[n][m];
        boolean[][] atl = new boolean[n][m];
         List<List<Integer>> list = new ArrayList();
        
        for (int i=0;i<m;i++) {
            dfs(0,i,heights,pac);
            dfs(n-1,i,heights,atl);
        }
        
        for (int i=0;i<n;i++) {
            dfs(i,0,heights,pac);
            dfs(i,m-1,heights,atl);
        }
                
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
                if ( atl[i][j] && pac[i][j] ) {
                    List<Integer> temp = new ArrayList();
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);
                }
        return list;
    }
     int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public void dfs(int i, int j, int[][] heights, boolean[][] visited) {
        visited[i][j] = true;
        
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if ( x < 0 || x >= heights.length || y < 0 || y >= heights[0].length || visited[x][y] || heights[x][y] < heights[i][j] ) continue;
            dfs(x,y,heights,visited);
        }
    }
}