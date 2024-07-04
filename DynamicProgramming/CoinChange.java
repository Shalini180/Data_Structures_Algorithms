class Solution {
    public int helper(int i, int[] coins, int amount, Integer[][] dp){
        if(amount == 0) return dp[i][amount] = 0;
        if(i >= coins.length || amount < 0) return -1;
        if(dp[i][amount] != null) return dp[i][amount];
        int op1 = -1;
        if(coins[i] <= amount)
            op1 = (helper(i, coins, amount - coins[i], dp) != -1) ? 1 + helper(i, coins, amount - coins[i], dp) : -1;
        int op2 = helper(i+1, coins, amount, dp);

        if(op1 == -1) return dp[i][amount] = op2;
        if(op2 == -1) return dp[i][amount] = op1;
        return dp[i][amount] = Math.min(op1, op2);
    }
    public int bottomUpHelper(int[] coins, int amount){
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int i = 0;i<=amount;i++) dp[0][i] = -1;
        for(int i = 0;i<=n;i++) dp[i][0] = 0;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=amount;j++){
                int op1 = -1;
                if(coins[i-1] <= j) {
                    if(dp[i][j - coins[i-1]] != -1) op1 = 1 + dp[i][j - coins[i-1]];
                }
                int op2 = dp[i-1][j];
                if(op1 == -1) dp[i][j] = op2;
                else if(op2 == -1) dp[i][j] = op1;
                else dp[i][j] = Math.min(op2, op1);
            }
        }

        return dp[n][amount];
    }
    public int coinChange(int[] coins, int amount) {
        Integer[][] dp = new Integer[coins.length + 1][amount + 1];
        // return helper(0, coins, amount, dp);
        return bottomUpHelper(coins, amount);
    }
}
