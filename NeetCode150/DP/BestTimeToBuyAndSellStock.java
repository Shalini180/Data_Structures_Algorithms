class Solution {
    public int helper(int day, boolean canBuy, int[] prices, int[][] dp) {
        if(day >= prices.length) return 0;
        int ind = canBuy ? 1 : 0;
        if(dp[day][ind] != -1) return dp[day][ind];

        int profit;
        if(canBuy) {
            int buy = -prices[day] + helper(day + 1, false, prices, dp);
            int skip = helper(day + 1, true, prices, dp);
            profit = Math.max(buy, skip);
        }
        else{
            int sell = prices[day] + helper(day + 2, true, prices, dp);
            int skip = helper(day + 1, false, prices, dp);
            profit = Math.max(sell, skip);
        }

        return dp[day][ind] = profit;
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] it : dp) Arrays.fill(it, -1);
        return helper(0, true, prices, dp);
    }
}
