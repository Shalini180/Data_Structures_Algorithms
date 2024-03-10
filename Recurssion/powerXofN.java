class Solution {
    public double pow(double x, int n){
        if(n == 0)
            return 1;

        double partialAns = pow(x, n/2);
        if(n%2 == 0)
            return partialAns * partialAns;
       
        return partialAns * partialAns * x;
    }
    public double myPow(double x, int n) {
        double ans = pow(x, Math.abs(n));
        if(n < 0)
            return 1/ans;
        
        return ans;
    }
}
