class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int it : nums) sum += it;

        int find = sum + target;
        if (find % 2 != 0 || sum < Math.abs(target)) return 0;

        find /= 2;
        int n = nums.length;
        int[][] dp = new int[n + 1][find + 1];

        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= find; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= find; j++) {
                System.out.println(dp[i][j]);
            }
        }

        return dp[n][find];
    }
}
