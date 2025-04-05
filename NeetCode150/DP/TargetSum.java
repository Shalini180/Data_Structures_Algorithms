class Solution {
    public int helper(int[] nums, int target, int i, int sum, Integer[][] dp, int offset) {
        if (i == nums.length) return sum == target ? 1 : 0;
        if (dp[i][sum + offset] != null) return dp[i][sum + offset];
        
        int add = helper(nums, target, i + 1, sum + nums[i], dp, offset);
        int subtract = helper(nums, target, i + 1, sum - nums[i], dp, offset);
        
        return dp[i][sum + offset] = add + subtract;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num : nums) total += num;
        if (Math.abs(target) > total) return 0;
        int offset = total;
        Integer[][] dp = new Integer[nums.length][2 * total + 1];
        return helper(nums, target, 0, 0, dp, offset);
    }
}
