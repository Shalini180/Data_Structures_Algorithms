class Solution {
    int[][] dp;
    public int helper(int currDay, int[] prices, int holding){
        if(currDay >= prices.length) return 0;
        if(dp[currDay][holding] != -1) return dp[currDay][holding];
        int sell = 0, buy = 0;
        if(holding == 1)
            sell = prices[currDay] + helper(currDay + 2, prices, 0);
        else if(holding == 0)
            buy = -prices[currDay] + helper(currDay + 1, prices, 1);
        int noAction = helper(currDay + 1, prices, holding);

        return dp[currDay][holding] = Math.max(noAction, Math.max(sell, buy));

    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n+1][2];
        for(int[] a : dp) Arrays.fill(a, -1);
        return helper(0, prices, 0);
    }
}
