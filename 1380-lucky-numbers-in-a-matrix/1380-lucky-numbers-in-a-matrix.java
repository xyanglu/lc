class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int[] r = new int[matrix.length];
        int[] c = new int[matrix[0].length];
        
        Arrays.fill(r,Integer.MAX_VALUE);
        for (int i=0;i<matrix.length;i++)
            for (int j=0;j<matrix[i].length;j++)
                r[i] = Math.min(matrix[i][j],r[i]);
        
                    for (int j=0;j<matrix[0].length;j++)
                                for (int i=0;i<matrix.length;i++)
                        c[j] = Math.max(c[j],matrix[i][j]);
        
        List<Integer> list = new ArrayList();
                    for (int i=0;i<matrix.length;i++)
            for (int j=0;j<matrix[i].length;j++)
                if ( matrix[i][j] == r[i] && matrix[i][j] == c[j] )
                    list.add(matrix[i][j]);
        return list;
    }
}