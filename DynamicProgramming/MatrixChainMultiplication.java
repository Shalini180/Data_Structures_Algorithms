class Solution{
    static int helper(int i, int j, int[] arr, int[][] dp){
        if(i >= j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        dp[i][j] = Integer.MAX_VALUE;
        for(int k = i;k<j;++k){
            int currCost = arr[i-1] * arr[k] * arr[j];
            int recursiveCost = helper(i, k, arr, dp) + helper(k+1, j, arr, dp);
            dp[i][j] = Math.min(dp[i][j], recursiveCost + currCost);
        }
        
        return dp[i][j];
    }
    static int matrixMultiplication(int N, int arr[])
    {
        int[][] dp = new int[N+1][N+1];
        for(int[] a : dp) Arrays.fill(a, -1);
        return helper(1, N-1, arr, dp);
    }
}
