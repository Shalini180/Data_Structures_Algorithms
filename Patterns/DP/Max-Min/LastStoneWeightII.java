import java.util.Arrays;

class Solution {
    
    public int topDownHelper(int[] stones, int totalSum, int currentSum, int ind, int[][] dp) {
        // Base case: if we've processed all the stones
        if (ind < 0) {
            return Math.abs((totalSum - currentSum) - currentSum);
        }
        
        // Check if we've already computed this state
        if (dp[ind][currentSum] != -1) return dp[ind][currentSum];
        
        // Option 1: Take the current stone and add it to the current sum
        int take = topDownHelper(stones, totalSum, currentSum + stones[ind], ind - 1, dp);
        
        // Option 2: Do not take the current stone
        int notTake = topDownHelper(stones, totalSum, currentSum, ind - 1, dp);
        
        // Store and return the result for the current state
        return dp[ind][currentSum] = Math.min(take, notTake);
    }
    
    public int bottomUpHelper(int[] stones, int totalSum) {
        int n = stones.length;
        int target = totalSum / 2; // We only need to consider sums up to totalSum / 2

        // Initialize the DP table to check achievable sums
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true; // We can always achieve 0 sum with 0 stones

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            int stone = stones[i - 1];
            for (int j = 0; j <= target; j++) {
                // If we can achieve the sum without the current stone
                dp[i][j] = dp[i - 1][j]; 
                // If we can achieve the sum including the current stone
                if (j >= stone) {
                    dp[i][j] |= dp[i - 1][j - stone]; 
                }
            }
        }

        // Find the maximum achievable sum <= target
        for (int j = target; j >= 0; j--) {
            if (dp[n][j]) {
                return totalSum - 2 * j; // Return the minimized difference
            }
        }

        return totalSum; // In case no stones can be taken, return total sum (edge case)
    }
    
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int a : stones) sum += a;

        // Uncomment to use the top-down approach
        // int[][] dp = new int[stones.length][sum + 1];
        // for (int[] row : dp) Arrays.fill(row, -1);
        // return topDownHelper(stones, sum, 0, stones.length - 1, dp);
        
        return bottomUpHelper(stones, sum);
    }
}
