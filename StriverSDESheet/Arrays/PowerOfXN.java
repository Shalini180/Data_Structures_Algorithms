class Solution {
    public double helper(double x, long n) {
        double ans = 1.0;
        while(n > 0) {
            if(n%2 == 0) {
                x = x*x;
                n = n/2;
            }
            else{
                ans = ans * x;
                n = n - 1;
            }
        }

        return ans;
    }
    public double myPow(double x, int n) {
        long exponential = n;
        if(n < 0) exponential = -(long)n;
        double ans = helper(x, exponential);
        if(n < 0) return (double)1.0/(double)ans;
        return ans;
    }
}
