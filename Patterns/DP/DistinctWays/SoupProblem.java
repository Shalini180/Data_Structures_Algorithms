class Solution {
    public int process(int a, int b){
        int target = a - b;
        if(target < 0) return 0;
        return target;
    }
    public double helper(int typeA, int typeB, double[][] dp){
        if(typeA == 0 && typeB > 0) return 1;
        if(typeA == 0 && typeB == 0) return 0.5;
        if(typeA > 0 && typeB == 0) return 0;
        if(dp[typeA][typeB] != -1) return dp[typeA][typeB];

        double op1 = helper(process(typeA, 100), process(typeB, 0), dp);
        double op2 = helper(process(typeA, 75), process(typeB, 25), dp);
        double op3 = helper(process(typeA, 50), process(typeB, 50), dp);
        double op4 = helper(process(typeA, 25), process(typeB, 75), dp);
        return dp[typeA][typeB] = 0.25 * (op1 + op2 + op3 + op4);
    }
    public double soupServings(int n) {
        if (n >= 5000) return 1.0;
        int size = (n + 24) / 25; 
        double[][] dp = new double[n+1][n+1];
        for(double[] it : dp) Arrays.fill(it, -1);
        return helper(n, n, dp);
    }
}
