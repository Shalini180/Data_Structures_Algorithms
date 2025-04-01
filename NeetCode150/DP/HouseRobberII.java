class Solution {
    public int helper(int[] nums, int start, int end, int[] dp) {
        if(start > end) return 0;
        if(dp[end] != -1) return dp[end];

        int cost1 = nums[end] + helper(nums, start, end - 2, dp);
        int cost2 = helper(nums, start, end - 1, dp);
        return dp[end] = Math.max(cost1, cost2);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int cost1 = helper(nums, 0, n - 2, dp);
        Arrays.fill(dp, -1);
        int cost2 = helper(nums, 1, n - 1, dp);
        return Math.max(cost1, cost2);
    }
}
