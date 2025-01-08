class Solution {
    public int helper(int i, int j, int m, int n, int[][] dp) {
        if(i == m && j == n) return 1;
        if(i > m || j > n) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = helper(i+1, j, m, n, dp) + helper(i, j+1, m, n, dp);
    }
    public int mainHelper(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int[] it : dp) Arrays.fill(it, -1);
        return helper(1, 1, m, n, dp);
    }
    public long combination(int n, int m){
        long ans = 1;
        for(int i = 0; i < m; i++) {
            ans = ans * (n - i);
            ans = ans /(i + 1);
        }

        return ans;
    }
    public int uniquePaths(int m, int n) {
        int totalWays = m + n - 2;

        int factor = Math.min(m, n) - 1;
        return (int)combination(totalWays, factor);
    }
}
