class Solution {
    public int topDownHelper(int[][] grid, int n, int m, int[][] dp) {
        if(n == 0 && m == 0) return grid[n][m];
        if(n < 0 || m < 0) return Integer.MAX_VALUE;
        if(dp[n][m] != -1) return dp[n][m];
        
        int currSum = grid[n][m] + Math.min(topDownHelper(grid, n-1, m, dp), topDownHelper(grid, n, m-1, dp));
        return dp[n][m] = currSum;
    }
    public int bottomUpHelper(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(i == 0 && j == 0) continue;
                int currCost = Integer.MAX_VALUE;
                if(i > 0) currCost = Math.min(currCost, dp[i-1][j]);
                if(j > 0) currCost = Math.min(currCost, dp[i][j-1]);
                dp[i][j] = currCost + grid[i][j];
            }
        }

        return dp[n-1][m-1];
    }
    public int minPathSum(int[][] grid) {
        // int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        // for(int[] temp : dp) Arrays.fill(temp, -1);
        // return topDownHelper(grid, grid.length - 1, grid[0].length - 1, dp);

        return bottomUpHelper(grid);
    }
}
