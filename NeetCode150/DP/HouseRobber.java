class Solution {
    public int helper(int[] nums, int n, int[] dp){
        if(n < 0) return 0;
        if(dp[n] != -1) return dp[n];
        int cost1 = nums[n] + helper(nums, n - 2, dp);
        int cost2 = helper(nums, n - 1, dp);
        return dp[n] = Math.max(cost1, cost2);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return Math.max(helper(nums, n - 1, dp) , helper(nums, n - 2, dp));
    }
}
