class Solution {
    public int topDownHelper(int i, int n, int[] dp){
        if(i == n) return 1;
        if(i > n) return 0;
        if(dp[i] != -1) return dp[i];
        int first = topDownHelper(i+1, n, dp);
        int second = topDownHelper(i+2, n, dp);
        return dp[i] = first + second;
    }
    public int bottomUpHelper(int n, int[] dp){
        if(n >= 1) dp[1] = 1; 
        if(n >= 2) dp[2] = 2;
        if(n <= 2) return dp[n];
        for(int i = 3;i<=n;i++){
            if(i - 1 >= 0) dp[i] += dp[i-1];
            if(i - 2 >= 0) dp[i] += dp[i-2];
        }

        return dp[n];
    }
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        return bottomUpHelper(n, dp);
    }
}
