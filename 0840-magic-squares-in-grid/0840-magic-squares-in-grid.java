import java.util.*;

class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rc = 0;

        // Iterate through each possible 3x3 subgrid
        for (int i = 0; i + 2 < grid.length; i++) {
            for (int j = 0; j + 2 < grid[0].length; j++) {
                if (isMagic(grid, i, j)) {
                    rc++;
                }
            }
        }

        return rc;
    }

    // Check if the 3x3 grid starting at (i, j) is a magic square
    private boolean isMagic(int[][] grid, int i, int j) {
        // Magic square numbers are 1 through 9, and sum should be 15
        int[] nums = new int[9];
        int index = 0;

        Set<Integer> seen = new HashSet<>();

        for (int row = i; row < i + 3; row++) {
            for (int col = j; col < j + 3; col++) {
                nums[index++] = grid[row][col];
                if (grid[row][col] < 1 || grid[row][col] > 9 || !seen.add(grid[row][col])) {
                    return false; // Invalid number or duplicate
                }
            }
        }

        return (nums[0] + nums[1] + nums[2] == 15) &&
               (nums[3] + nums[4] + nums[5] == 15) &&
               (nums[6] + nums[7] + nums[8] == 15) &&
               (nums[0] + nums[3] + nums[6] == 15) &&
               (nums[1] + nums[4] + nums[7] == 15) &&
               (nums[2] + nums[5] + nums[8] == 15) &&
               (nums[0] + nums[4] + nums[8] == 15) &&
               (nums[2] + nums[4] + nums[6] == 15);
    }
}
