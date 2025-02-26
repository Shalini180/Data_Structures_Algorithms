class Solution {
    public boolean helper(int[] nums, int target, int ind, Boolean[][] dp){
        if(target == 0) return true;
        if(ind == 0) return false;
        if(dp[ind][target] != null) return dp[ind][target];

        boolean take = false;
        if(nums[ind - 1] <= target){
            take = helper(nums, target - nums[ind - 1], ind - 1, dp);
        }

        boolean notTake = helper(nums, target, ind - 1, dp);
        return dp[ind][target] = take || notTake;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int it : nums) sum += it;
        if(sum % 2 != 0) return false;
        Boolean[][] dp = new Boolean[nums.length + 1][(sum/2) + 1];
        for(Boolean[] a : dp) Arrays.fill(a, null);
        return helper(nums, sum/2, nums.length, dp);
    }
}
