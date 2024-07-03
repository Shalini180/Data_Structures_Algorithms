class Solution {
    public int topDownHelper(String word1, String word2, int i, int j, int[][] dp){
        if(i == word1.length() && j == word2.length()) return 0;
        if(i == word1.length()) return word2.length() - j;
        if(j == word2.length()) return word1.length() - i;
        if(dp[i][j] != - 1) return dp[i][j];
        if(word1.charAt(i) == word2.charAt(j)){
            return dp[i][j] = topDownHelper(word1, word2, i+1, j+1, dp);
        }
        else{
            // Insert a character
            int op1 = 1 + topDownHelper(word1, word2, i, j+1, dp);
            // Delete a character
            int op2 = 1 + topDownHelper(word1, word2, i+1, j, dp);
            // Replace a character
            int op3 = 1 + topDownHelper(word1, word2, i+1, j+1, dp);
            return dp[i][j] = Math.min(Math.min(op1, op2), op3);
        }
    }
    public int bottomUpHelper(String word1, String word2){
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1;i<=n;i++) dp[i][0] = i;
        for(int i = 1;i<=m;i++) dp[0][i] = i;
        dp[0][0] = 0;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1;
                    dp[i][j] += Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                }
            }
        }

        return dp[n][m];
    }
    public int minDistance(String word1, String word2) {
        // int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // for(int[] a : dp) Arrays.fill(a, -1);
        // return topDownHelper(word1, word2, 0, 0, dp);

        return bottomUpHelper(word1, word2);
    }
}
