class Solution {
    public int updatedTarget(int[] nums, int target){
        int sum = 0;
        for(int it : nums) sum += it;
        sum += target;
        if(sum % 2 == 1) return -1;
        return sum/2;
    }
    public int helper(int[] nums, int target, int i, int[][] dp){
        if(target == 0 && i == nums.length) return 1;
        if(target < 0 || i >= nums.length) return 0;
        if(dp[target][i] != -1) return dp[target][i];
        int take = 0, notTake = 0;
        if(nums[i] == 0){
            take = 2 * helper(nums, target - nums[i], i+1, dp);
        }
        else{
            take = helper(nums, target - nums[i], i+1, dp);
            notTake = helper(nums, target, i+1, dp);
        }
       
        return dp[target][i] = take + notTake;
    }
    public int findTargetSumWays(int[] nums, int target) {
       int updatedTarget = updatedTarget(nums, target);
       if(updatedTarget < 0) return 0;
       int[][] dp = new int[updatedTarget + 1][nums.length + 1];
       for(int[] it : dp) Arrays.fill(it, -1);
       return helper(nums, updatedTarget, 0, dp);
    }
}
