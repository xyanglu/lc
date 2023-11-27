public class Solution {

    public static int knightDialer(int n) {
        final int MOD = 1_000_000_007;
        
        int[][] moves = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6},{1, 3}, {2, 4}};

        int[][] dp = new int[n][10];

        // Initialize base case: one move of length 1
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        // Build up the number of ways for each move length
        for (int move = 1; move < n; move++) {
            for (int i = 0; i < 10; i++) {
                for (int next : moves[i]) {
                    dp[move][i] = (dp[move][i] + dp[move - 1][next]) % MOD;
                }
            }
        }

        // Sum up the number of ways for all numeric cells for the final move length
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result + dp[n - 1][i]) % MOD;
        }

        return result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(knightDialer(1));   // Output: 10
        System.out.println(knightDialer(2));   // Output: 20
        System.out.println(knightDialer(3131));// Output: 136006598
    }
}
