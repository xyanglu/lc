/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int m = binaryMatrix.dimensions().get(1);
        int n = binaryMatrix.dimensions().get(0);
     
        int i = 0;
        int j = m - 1;
        int min = Integer.MAX_VALUE;
        while ( i < n && j >= 0 ) {
            int val = binaryMatrix.get(i,j);
            if ( val == 0 )
            {
                i++;
                continue;
            }
            if ( val == 1 ) {
                                min = Math.min(min,j);

                j--;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}