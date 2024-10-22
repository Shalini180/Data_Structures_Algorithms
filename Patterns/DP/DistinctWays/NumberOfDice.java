class Solution {
    private static final int mod = 1_000_000_007;
    public int helper(int n, int k, int target, int[][] dp) {
        if(n == 0 && target == 0) return 1;
        if(n == 0 || target < 0) return 0;
        if(dp[n][target] != -1) return dp[n][target];
        int ways = 0;
        for(int i = 1; i <= k; i++){
            ways += helper(n-1, k, target - i, dp);
            ways = ways % mod;
        }

        return dp[n][target] = ways;
    }
    public int bottomUpHelper(int n, int k, int target){
        int[][] dp = new int[n+1][target+1];
        for(int i = 0; i <= target; i++) dp[0][i] = 0;
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= target; j++){
                for(int l = 1; l <= k; l++){
                    if((j-l) < 0) continue;
                    dp[i][j] += dp[i-1][j-l];
                    dp[i][j] = dp[i][j] % mod;
                }
            }
        }

        return dp[n][target];
    }
    public int numRollsToTarget(int n, int k, int target) {
        // int[][] dp = new int[n+1][target+1];
        // for(int[] temp : dp) Arrays.fill(temp, -1);
        // return helper(n, k, target, dp);

        return bottomUpHelper(n, k, target);
    }
}
