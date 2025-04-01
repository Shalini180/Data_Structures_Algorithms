class Solution {
    public int helper(int[] coins, int amount, int i, int[][] dp) {
        if (amount == 0) return 0;
        if (amount < 0 || i == coins.length) return Integer.MAX_VALUE - 1;
        if(dp[amount][i] != -1) return dp[amount][i];

        int way1 = Integer.MAX_VALUE - 1;
        if (coins[i] <= amount) {
            int subResult = helper(coins, amount - coins[i], i, dp);
            if (subResult != Integer.MAX_VALUE - 1) {
                way1 = 1 + subResult;
            }
        }

        int way2 = helper(coins, amount, i + 1, dp);
        return dp[amount][i] = Math.min(way1, way2);
    }

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[amount + 1][coins.length];
        for(int[] it : dp) Arrays.fill(it, -1);
        int result = helper(coins, amount, 0, dp);
        return result == Integer.MAX_VALUE - 1 ? -1 : result;
    }
}
