class Solution {
    // Helper function to count zeroes and ones in a string
    int[] findZeroesAndOnes(String a) {
        int[] count = new int[2];
        Arrays.fill(count, 0);
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '0') count[0]++;
            if (a.charAt(i) == '1') count[1]++;
        }
        return count;
    }

    // Top-down recursive helper using 2D DP array
    public int helper(String[] strs, int m, int n, int ind, int[][] dp) {
        if (ind < 0) return 0; // Base case: no more strings to process
        if (m < 0 || n < 0) return -2; // Invalid case: exceeded the limit of 0's or 1's

        // Memoization check: if already computed, return the result
        if (dp[n][m] != -1) return dp[n][m];

        // Get the counts of 0's and 1's for the current string
        int[] count = findZeroesAndOnes(strs[ind]);
        int zeroes = count[0];
        int ones = count[1];

        // Option 1: Take the current string if possible
        int take = -2; // Initialize to an invalid value
        if (m >= zeroes && n >= ones) {
            take = 1 + helper(strs, m - zeroes, n - ones, ind - 1, dp);
        }

        // Option 2: Don't take the current string
        int notTake = helper(strs, m, n, ind - 1, dp);

        // Store and return the maximum result of taking or not taking the current string
        return dp[n][m] = Math.max(take, notTake);
    }

    // Bottom-up dynamic programming approach
    public int bottomUpHelper(String[] strs, int m, int n) {
        // Initialize a 2D DP array where dp[i][j] represents the max number of strings
        // that can be formed with i 0's and j 1's.
        int[][] dp = new int[m + 1][n + 1];

        // Iterate over each string in strs
        for (String str : strs) {
            // Get the count of 0's and 1's in the current string
            int[] count = findZeroesAndOnes(str);
            int zeroes = count[0];
            int ones = count[1];

            // Update the dp array from bottom to top to avoid overwriting previous states.
            // We iterate from m to zero and n to zero to maintain the previous results.
            for (int i = m; i >= zeroes; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeroes][j - ones]);
                }
            }
        }
        // The result is the value at dp[m][n] — the maximum number of strings that can be formed.
        return dp[m][n];
    }

    // Main function to choose between top-down and bottom-up approaches
    //TC : o(m*n*k)
    public int findMaxForm(String[] strs, int m, int n) {
        // Uncomment the following for top-down approach:
        /*
        int[][] dp = new int[n + 1][m + 1];
        for (int[] temp : dp) Arrays.fill(temp, -1);
        return helper(strs, m, n, strs.length - 1, dp);
        */

        // Use the bottom-up approach:
        return bottomUpHelper(strs, m, n);
    }
}
