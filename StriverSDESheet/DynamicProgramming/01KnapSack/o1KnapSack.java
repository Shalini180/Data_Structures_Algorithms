class Solution {
    static int helper(int capacity, int val[], int wt[], int ind, int[][] dp){
        if(capacity <= 0 || ind < 0) return 0;
        if(dp[capacity][ind] != -1) return dp[capacity][ind];
        int take = 0;
        if(capacity >= wt[ind]){
            take = val[ind] + helper(capacity - wt[ind], val, wt, ind - 1, dp);
        }
        
        int notTake = helper(capacity, val, wt, ind - 1, dp);
        return dp[capacity][ind] = Math.max(take, notTake);
    }
    static int knapSack(int capacity, int val[], int wt[]) {
        int[][] dp = new int[capacity + 1][val.length];
        for(int i = 0; i < capacity + 1; i++){
            for(int j = 0; j < val.length;j++) dp[i][j] = -1;
        }
        return helper(capacity, val, wt, val.length - 1, dp);
    }
}
