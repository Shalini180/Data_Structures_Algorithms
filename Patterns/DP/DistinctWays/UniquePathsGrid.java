class Solution {
    public int topDownHelper(int m, int n, int i, int j, int[][] dp){
        if(i == (m-1) && j == (n-1)) return 1;
        if(i < 0 || i >= m) return 0;
        if(j < 0 || j >= n) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        return dp[i][j] = topDownHelper(m, n, i+1, j, dp) + topDownHelper(m, n, i, j+1, dp);
    }

    public int bottomUpHelper(int m, int n){
        int[][] dp = new int[m][n];
        for(int i = 0; i< m;i++) dp[i][0] = 1;
        for(int i = 0;i< n;i++) dp[0][i] = 1;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
    public int uniquePaths(int m, int n) {
        // int[][] dp = new int[m+1][n+1];
        // for(int[] temp : dp) Arrays.fill(temp, -1);
        // return topDownHelper(m, n, 0, 0, dp);

        return bottomUpHelper(m, n);
    }
}
