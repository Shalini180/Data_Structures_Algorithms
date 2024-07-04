class Solution {
    public boolean helper(int i, int[] nums, int sum, Boolean[][] dp){
        if(sum == 0) return dp[i][sum] = true;
        if(i >= nums.length || sum < 0) return false;
        if(dp[i][sum] != null) return dp[i][sum];
        boolean op1 = helper(i+1, nums, sum - nums[i], dp);
        boolean op2 = helper(i+1, nums, sum, dp);
        return dp[i][sum] = op1 || op2;
    }
    public int calculateTargetSum(int[] nums){
        int s = 0;
        for(int ele : nums) s+= ele;
        return s;
    }
    public boolean canPartition(int[] nums) {
        int target = calculateTargetSum(nums);
        if(target%2 != 0) return false;
        Boolean[][] dp = new Boolean[nums.length + 1][target/2 + 1];
        return helper(0, nums, target/2, dp);
    }
}
