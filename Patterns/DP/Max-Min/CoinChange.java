class Solution {
    public int topDownHelper(int[] coins, int amount, int n, int[][] dp) {
        if (n < 0) {
            return (amount == 0) ? 0 : Integer.MAX_VALUE;
        }
        if (dp[n][amount] != -1) return dp[n][amount];

        int op1 = Integer.MAX_VALUE;
        if (amount >= coins[n]) {
            op1 = topDownHelper(coins, amount - coins[n], n, dp);
            op1 = (op1 == Integer.MAX_VALUE) ? op1 : op1 + 1;
        }
        int op2 = topDownHelper(coins, amount, n - 1, dp);

        return dp[n][amount] = Math.min(op1, op2);
    }

    public int bottomUpHelper(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // Initialize the dp array
        for (int j = 1; j <= amount; j++) dp[0][j] = Integer.MAX_VALUE; // No coins available to make the amount
        for (int i = 0; i <= n; i++) dp[i][0] = 0; // No amount to make requires 0 coins

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                int op1 = Integer.MAX_VALUE;
                if (j >= coins[i - 1]) {
                    op1 = (dp[i][j - coins[i - 1]] == Integer.MAX_VALUE) ? dp[i][j - coins[i - 1]] : dp[i][j - coins[i - 1]] + 1;
                }
                dp[i][j] = Math.min(op1, dp[i - 1][j]);
            }
        }

        return (dp[n][amount] == Integer.MAX_VALUE) ? -1 : dp[n][amount];
    }

    public int coinChange(int[] coins, int amount) {
        // Uncomment if using the top-down approach
        // int[][] dp = new int[coins.length + 1][amount + 1];
        // for (int[] temp : dp) Arrays.fill(temp, -1);
        // int value = topDownHelper(coins, amount, coins.length - 1, dp);
        // return (value == Integer.MAX_VALUE) ? -1 : value;

        return bottomUpHelper(coins, amount); // Using the bottom-up approach
    }
}
