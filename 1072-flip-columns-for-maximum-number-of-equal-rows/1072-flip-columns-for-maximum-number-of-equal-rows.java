class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String,Integer> map = new HashMap();
        for (int i=0;i<matrix.length;i++) {
            if ( matrix[i][0] == 0 ) {
                for (int j=0;j<matrix[i].length;j++)
                    matrix[i][j] = 1 - matrix[i][j];
            }
            String row = Arrays.toString(matrix[i]);
            map.put(row, map.getOrDefault(row,0)+1 );
            // System.out.println(row+" "+map.get(row));
        }
        
        int max = 0;
        for (int v : map.values() )
            max = Math.max(max,v);
        
        return max;
    }
}