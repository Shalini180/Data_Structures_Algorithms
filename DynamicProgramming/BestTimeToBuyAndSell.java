class Solution {
    int[][] dp;
    public int helper(int currDay, int[] prices, int holding){
        if(currDay >= prices.length) return 0;
        if(dp[currDay][holding] != -1) return dp[currDay][holding];
        int buy = 0;
        int sell = 0;
        if(holding == 1)
            sell = prices[currDay] + helper(currDay + 1, prices, 0);
        else
            buy = - prices[currDay] + helper(currDay + 1, prices, 1);
        int noAction = helper(currDay + 1, prices, holding);
        
        return dp[currDay][holding] = Math.max(buy, Math.max(sell, noAction));
    }
    public int topDownHelper(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int i = n - 1;i>=0;i--){
            int buy = 0, sell = 0, noAction = 0;
            for(int j = 0;j<2;j++){
                if(j == 0)
                    buy = -prices[i] + dp[i+1][1];
                else if(j == 1)
                    sell = +prices[i] + dp[i+1][0];
                noAction = dp[i+1][j];

                dp[i][j] = Math.max(Math.max(buy, sell), noAction);
            }
        }

        return dp[0][0];
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        return topDownHelper(prices);
        // dp = new int[n][2];
        // for(int[] a : dp) Arrays.fill(a, -1);
        // return helper(0, prices, 0);
    }
}
