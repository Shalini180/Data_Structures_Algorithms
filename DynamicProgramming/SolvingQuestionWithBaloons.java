class Solution {
    public long maxPoints(int i, int[][] questions, long[] dp){
        if(i >= questions.length) return 0;
        if(dp[i] != -1) return dp[i];

        long first = questions[i][0] + maxPoints(i+questions[i][1]+1, questions, dp);
        long second = maxPoints(i+1, questions, dp);
        return dp[i] = Math.max(first, second);
    }
    public long bottomUpHelper(int[][] questions){
        int n = questions.length;
        long[] dp = new long[n + 1];
        for(int i = n - 1; i >= 0; i--){
            long first = questions[i][0];
            int index = i + questions[i][1] + 1;
            if(index < n) first += dp[index];
            long second = dp[i+1];
            dp[i] = Math.max(first, second);
        }

        return dp[0];

    }
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        Arrays.fill(dp, -1);
        // return maxPoints(0, questions, dp);
        return bottomUpHelper(questions);
    }
}
