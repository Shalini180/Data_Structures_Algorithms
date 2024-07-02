class Solution {
    public int helper(int i, int j, int m, int n, int[][] obstacleGrid, int[][] dp){
        if(i == m - 1 && j == n - 1) return dp[i][j] = 1;
        if(i >= m || j >= n || obstacleGrid[i][j] == 1) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int right = helper(i, j+1, m, n, obstacleGrid, dp);
        int down = helper(i+1, j, m, n, obstacleGrid, dp);
        return dp[i][j] = right + down;
    }
    public int bottomUpHelper(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        boolean flag = false;
        int d = 0;
        while(d < m){
            if(obstacleGrid[d][0] == 1 || flag == true){
                dp[d][0] = 0;
                flag = true;
            }
            else{
                dp[d][0] = 1;
            }
            d++;
        }

        int r = 0;
        flag = false;
        while(r < n){
             if(obstacleGrid[0][r] == 1 || flag == true){
                dp[0][r] = 0;
                flag = true;
            }
            else{
                dp[0][r] = 1;
            }
            r++;
        }

        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1) return 0;

        // int[][] dp = new int[m][n];
        // for(int i = 0;i<m;i++) Arrays.fill(dp[i], - 1);
        //return helper(0, 0, m, n, obstacleGrid, dp);

        return bottomUpHelper(obstacleGrid);
    }
}
