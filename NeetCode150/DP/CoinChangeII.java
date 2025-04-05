class Solution {
    public int helper(int amount, int[] coins, int i, int[][] dp) {
        if(amount < 0 || i == coins.length) return 0;
        if(amount == 0) return 1;
        if(dp[amount][i] != -1) return dp[amount][i];
        int notTake = helper(amount, coins, i + 1, dp);
        int take = helper(amount - coins[i], coins, i, dp);
        return dp[amount][i] = take + notTake;
    }
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        for(int[] it : dp) Arrays.fill(it, -1);
        return helper(amount, coins, 0, dp);
    }
}
