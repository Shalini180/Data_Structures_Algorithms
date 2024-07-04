class Solution {
    public int helper(int ind, int prevInd, int[] nums, int[][] dp){
        if(ind == nums.length) return 0;
        if(dp[ind][prevInd + 1] != -1) return dp[ind][prevInd + 1];
        int op1 = helper(ind + 1, prevInd, nums, dp);
        int op2 = 0;
        if(prevInd == -1 || nums[ind] > nums[prevInd])
            op2 = helper(ind + 1, ind, nums, dp) + 1;
        return dp[ind][prevInd + 1] = Math.max(op1, op2);
    }
    public int bottomUpHelper(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 0;i<n;i++){
            int maxi = 1;
            for(int j = i-1;j>=0;j--){
                if(nums[i] > nums[j]){
                    maxi = Math.max(maxi, 1 + dp[j]);
                }
            }

            dp[i] = maxi;
        }

        int totalMax = 0;
        for(int i = 0;i<nums.length;i++) totalMax = Math.max(totalMax, dp[i]);
        return totalMax;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] a : dp) Arrays.fill(a, -1);
        // return helper(0, -1, nums, dp);
        return bottomUpHelper(nums);
    }
}
