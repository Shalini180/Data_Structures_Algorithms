class Solution {
    public Boolean helper(String s, int i, int j, Boolean[][] dp) {
        if(dp[i][j] != null) return dp[i][j];
        if(i == j) {
            return dp[i][j] = true;
        }
        if(s.charAt(i) == s.charAt(j) && ((j - i) == 1 || helper(s, i + 1, j - 1, dp))){
            return dp[i][j] = true;
        }
        return dp[i][j] = false;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        Boolean[][] dp = new Boolean[n][n];
        for(Boolean[] it : dp) Arrays.fill(it, null);
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (helper(s, i, j, dp)) {
                    int currLen = j - i + 1;
                    if (currLen > maxLen) {
                        maxLen = currLen;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
