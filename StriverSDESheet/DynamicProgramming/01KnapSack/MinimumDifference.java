import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums) {
        int s = 0, n = nums.length;
        int minValue = Arrays.stream(nums).min().getAsInt();
        
        if (minValue < 0) {
            for (int i = 0; i < n; i++) {
                nums[i] -= minValue;
            }
        }

        for (int it : nums) s += it;
        int target = s / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        int s1 = target;
        while (s1 >= 0) {
            if (dp[n][s1]) break;
            s1--;
        }

        return Math.abs(s - 2 * s1);
    }
}
