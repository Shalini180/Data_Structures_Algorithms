class Solution {
    public boolean helper(int n, boolean flag, boolean[] dp){
        if(n <= 1 && flag == false) return true;
        if(n <= 1 && flag == true) return false;
        if(dp[n] != false) return dp[n];
        for(int j = 1;j<n;j++){
            if(n % j == 0){
                return dp[n] = helper(n - j, !flag, dp);
            }
        }

        return false;
    }
    public boolean divisorGame(int n) { 
        boolean[] dp = new boolean[n+1];
        Arrays.fill(dp, false);
        return helper(n, true, dp);
    }
}
