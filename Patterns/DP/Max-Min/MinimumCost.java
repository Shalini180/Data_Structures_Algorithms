class Solution {
    // Top-down dynamic programming helper function
    public int topDownHelper(int[] days, int[] costs, int n, int[] dp) {
        // Base case: if no more days to process, return 0
        if (n < 0) return 0;
        
        // If result is already computed, return it
        if (dp[n] != -1) return dp[n];
        
        // Option 1: Buy a 1-day pass
        int op1 = costs[0] + topDownHelper(days, costs, n - 1, dp);
        
        // Option 2: Buy a 7-day pass
        int i;
        for (i = n; i >= 0 && days[i] > days[n] - 7; i--);
        int op2 = costs[1] + topDownHelper(days, costs, i, dp);
        
        // Option 3: Buy a 30-day pass
        for (i = n; i >= 0 && days[i] > days[n] - 30; i--);
        int op3 = costs[2] + topDownHelper(days, costs, i, dp);
        
        // Store the result in dp and return the minimum cost
        return dp[n] = Math.min(op1, Math.min(op2, op3));
    }

    // Bottom-up dynamic programming helper function
    public int bottomUpHelper(int[] days, int[] costs) {
        int n = days.length;
        int lastDay = days[n - 1];
        int[] dp = new int[lastDay + 1];  // DP array from day 0 to the last travel day
        
        // Initialize variables
        int index = 0;

        // Iterate through each day from day 1 to the last travel day
        for (int i = 1; i <= lastDay; i++) {
            // If not a travel day, carry forward the previous day's cost
            if (i != days[index]) {
                dp[i] = dp[i - 1];
            } else {
                // If it's a travel day, calculate the minimum cost
                int op1 = costs[0] + dp[Math.max(0, i - 1)];   // 1-day pass
                int op2 = costs[1] + dp[Math.max(0, i - 7)];   // 7-day pass
                int op3 = costs[2] + dp[Math.max(0, i - 30)];  // 30-day pass
                
                // Take the minimum of the three options
                dp[i] = Math.min(op1, Math.min(op2, op3));
                
                // Move to the next travel day
                index++;
                if (index == n) break;  // All travel days are processed
            }
        }

        // Return the minimum cost to cover all travel days
        return dp[lastDay];
    }

    // Main function to calculate minimum cost for tickets
    public int mincostTickets(int[] days, int[] costs) {
        return bottomUpHelper(days, costs);
        
        // Top-down approach (uncomment if needed)
        // int[] dp = new int[days.length];
        // Arrays.fill(dp, -1);
        // return topDownHelper(days, costs, days.length - 1, dp);
    }
}
