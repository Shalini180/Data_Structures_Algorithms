class Solution{
    public static boolean helper(int i, int arr[], int sum, int n, Boolean[][] dp){
        if(sum == 0) return dp[i][sum] = true;
        if(i >= n || sum < 0) return false;
        if(dp[i][sum] != null) return dp[i][sum];
        Boolean op1 = helper(i+1, arr, sum - arr[i], n, dp);
        Boolean op2 = helper(i+1, arr, sum, n, dp);
        return dp[i][sum] = op1 || op2;
    }
    public static boolean bottomUpHelper(int arr[], int n, int sum){
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i = 1;i<=sum;i++) dp[0][i] = false;
        for(int i = 0;i<=n;i++) dp[i][0] = true;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=sum;j++){
                dp[i][j] = dp[i-1][j];
                if(arr[i-1] <= j) dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j]; 
            }
        }
        
        return dp[n][sum];
    }
    static Boolean isSubsetSum(int N, int arr[], int sum){
        Boolean[][] dp = new Boolean[N+1][sum+1];
        // return helper(0, arr, sum, N, dp);
        return bottomUpHelper(arr, N, sum);
    }
}
