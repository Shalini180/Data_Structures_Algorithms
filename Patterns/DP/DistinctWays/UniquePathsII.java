class Solution {
    public int helper(int i, int j, int[][] obstacleGrid, int n, int m, int[][] dp){
        if(i == m && j == n) return 1;
        if(i > m) return 0;
        if(j > n) return 0;
        if(obstacleGrid[j-1][i-1] == 1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        int right = helper(i+1, j, obstacleGrid, n, m, dp);
        int down = helper(i, j+1, obstacleGrid, n, m, dp);
        return dp[i][j] = right + down;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[n-1][m-1] == 1) return 0;
        
        int[][] dp = new int[m+1][n+1];
        for(int[] it : dp) Arrays.fill(it, -1);
        return helper(1, 1, obstacleGrid, n, m, dp);
    }
}
