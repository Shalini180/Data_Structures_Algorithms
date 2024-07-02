class Solution {
    public int topDownHelper(int i, int j, String text1, String text2, int[][] dp) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + topDownHelper(i + 1, j + 1, text1, text2, dp);
        }
        
        return dp[i][j] = Math.max(topDownHelper(i + 1, j, text1, text2, dp), topDownHelper(i, j + 1, text1, text2, dp));
    }
    
    public int bottomUpHelper(String text1, String text2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[n][m];
    }
    
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        // return topDownHelper(0, 0, text1, text2, dp);
        return bottomUpHelper(text1, text2, n, m);
    }
}
