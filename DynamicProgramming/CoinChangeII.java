class Solution {
    public int topDownHelper(int i, int amount, int[] coins, int[][] dp){
        if(amount == 0) return 1;
        if(amount < 0 || i >= coins.length) return 0;
        if(dp[i][amount] != -1) return dp[i][amount];
        int op1 = topDownHelper(i, amount - coins[i], coins, dp);
        int op2 = topDownHelper(i+1, amount, coins, dp);
        return dp[i][amount] = op1 + op2;
    }
    public int bottomUpHelper(int amount, int[] coins, int n){
        int[][] dp = new int[n+1][amount+1];
        for(int i = 0;i<=amount;i++) dp[0][i] = 0;
        for(int i = 0;i<=n;i++)  dp[i][0] = 1;
        
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=amount;j++){
                if(j - coins[i-1] >= 0) dp[i][j] += dp[i][j-coins[i-1]];
                dp[i][j] += dp[i-1][j];
            }
        }

        return dp[n][amount];
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // int[][] dp = new int[n+1][amount+1];
        // for(int[] a : dp) Arrays.fill(a, -1);
        // return topDownHelper(0, amount, coins, dp);
        return bottomUpHelper(amount, coins, n);
    }
}
