class Solution {
    public int topDownHelper(int i, int[] nums, int[] dp){
        if(i >= nums.length) return 0;
        if(dp[i] != - 1) return dp[i];
        int robCurrent = nums[i] + topDownHelper(i+2, nums, dp);
        int robNext = topDownHelper(i+1, nums, dp);
        return dp[i] = Math.max(robCurrent, robNext);
    }
    
    public int bottomUpHelper(int[] nums, int[] dp){
        if(nums.length >= 1) dp[0] = nums[0];
        if(nums.length >= 2) dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2;i<nums.length;i++){
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i]);
            dp[i] = Math.max(dp[i - 1], dp[i]);
        }

        return dp[nums.length - 1];
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);

        // return topDownHelper(0, nums, dp);
        return bottomUpHelper(nums, dp);
    }
}
