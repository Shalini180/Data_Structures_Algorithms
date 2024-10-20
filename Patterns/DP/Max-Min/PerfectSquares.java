class Solution {
    public List<Integer> perfectSquares(int n){
        List<Integer> answer = new ArrayList<>();
        for(int i = 1; i*i <= n;i++){
            answer.add(i*i);
        }

        return answer;
    }
    public int helper(int n, List<Integer> a, int ind, int[][] dp){
        if(n == 0) return 0;
        if(n < 0 || ind >= a.size()) return Integer.MAX_VALUE;
        if(dp[n][ind] != -1) return dp[n][ind];
        int take = helper(n - a.get(ind), a, ind, dp);
        if(take != Integer.MAX_VALUE) take += 1;
        int notTake = helper(n, a, ind + 1, dp);
        return dp[n][ind] = Math.min(take, notTake);
    }
    public int numSquares(int n) {
        List<Integer> perfectSquare = perfectSquares(n);
        int[][] dp = new int[n+1][perfectSquare.size()+1];
        for(int[] temp : dp) Arrays.fill(temp, -1);
        return helper(n, perfectSquare, 0, dp);

    }
}
