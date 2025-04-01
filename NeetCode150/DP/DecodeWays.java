class Solution {
    public int helper(String s, int start, int[] dp) {
        if(start == s.length()) return 1;
        if (s.charAt(start) == '0') return 0;;
        if(dp[start] != -1) return dp[start];

        int way1 = helper(s, start + 1, dp);
        int way2 = 0;
        if (start + 1 < s.length()) {
            int num = Integer.valueOf(s.substring(start, start + 2));
            if (num <= 26) {
                way2 = helper(s, start + 2, dp);
            }
        }
        return dp[start] = way1 + way2;
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(s, 0, dp);
    }
}
