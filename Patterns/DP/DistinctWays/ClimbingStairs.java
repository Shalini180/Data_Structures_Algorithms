class Solution {
    public int topDownHelper(int i, int n, int[] dp){
        if(i == n) return 1;
        if(i > n) return 0;
        if(dp[i] != -1) return dp[i];
        int stepOne = topDownHelper(i+1, n, dp);
        int stepTwo = topDownHelper(i+2, n, dp);
        return dp[i] = stepOne + stepTwo;
    }
    public int bottomUpHelper(int n){
        if(n == 1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
    public int climbStairs(int n) {
        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return topDownHelper(0, n, dp); 

        return bottomUpHelper(n);
    }
}
