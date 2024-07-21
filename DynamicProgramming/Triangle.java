class Solution {
    int[][] dp;
    public int helper(int i, int j, List<List<Integer>> triangle){
        if(i == triangle.size()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        if(triangle.get(i).size() - 1 >= j){
            first = triangle.get(i).get(j) + helper(i+1, j, triangle);
        }
        if(triangle.get(i).size() - 1 > j){
            second = triangle.get(i).get(j+1) + helper(i+1, j+1, triangle);
        }

        return dp[i][j] = Math.min(first, second);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(0).size();

        dp = new int[n+1][n+1];
        for(int[] a : dp) Arrays.fill(a, -1);

        return helper(0, 0, triangle);
    }
}
