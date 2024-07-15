class Solution {
    int[][] dp;
    int[] dp2;
    public int isPal(String s, int i, int j){
        if(i >= j) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = (s.charAt(i) == s.charAt(j) && isPal(s, i+1, j-1) == 1) ? 1 : 0;
    }
    public int minHelp(int i, String s){
        if(i >= s.length() || isPal(s, i, s.length() - 1) == 1)
            return 0;
        if(dp2[i] != -1) return dp2[i];
        dp2[i] = Integer.MAX_VALUE;
        for(int k = i;k<s.length();++k){
            if(isPal(s, i, k) == 0) continue;
            dp2[i] = Math.min(dp2[i], 1 + minHelp(k+1, s));
        }

        return dp2[i];
    }
    public int minCut(String s) {
        int n = s.length();
        dp = new int[n][n];
        dp2 = new int[n];
        Arrays.fill(dp2, -1);
        for(int[] a : dp) Arrays.fill(a, -1);
        return minHelp(0, s);
    }
}
