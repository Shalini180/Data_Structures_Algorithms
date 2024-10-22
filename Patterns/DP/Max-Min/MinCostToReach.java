class Solution {
    public int helper(int start, int end, int[] cost, int[] dp){
        if(start >= end) return 0;
        if(start > end) return 1000;
        if(dp[start] != -1) return dp[start];
        int stepOne = helper(start + 1, end, cost, dp) + cost[start];
        int stepTwo = helper(start + 2, end, cost, dp) + cost[start];
        return dp[start] = Math.min(stepOne, stepTwo);
    }
    public int minCostClimbingStairs(int[] cost) {
        int start = 0;
        int end = cost.length;
        int[] dp = new int[end+1];
        Arrays.fill(dp, -1);
        return Math.min(helper(start, end, cost, dp), helper(start + 1, end, cost, dp));

    }
}
