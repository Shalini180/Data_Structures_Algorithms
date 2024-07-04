class Solution{
    private static final int INF = 1_000_000_000;
    public int helper(int i, int n, int arr[], int[] dp){
        if(i == n - 1) return 0;
        if(dp[i] != -1) return dp[i];
        
        int op1 = INF;
        if(i + 1 < n)
            op1 = Math.abs(arr[i] - arr[i+1]) + helper(i+1, n, arr, dp);
            
        int op2 = INF;
        if(i + 2 < n)
            op2 = Math.abs(arr[i] - arr[i+2]) + helper(i+2, n, arr, dp);
        return dp[i] = Math.min(op1, op2);
    }
    public int minimumEnergy(int arr[],int N){
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        return helper(0, N, arr, dp);
    }
}
