class Solution {
    public double power(double a){
        return a * a;
    }
    public int helper(int x){
        double low = 1;
        double high = x;
        double eps = 1e-6;
        while((high - low) > eps){
            double mid = (low + high)/2.0;
            if(power(mid) < x) low = mid;
            else high = mid;
        }

        return (int)high;
    }
    public int mySqrt(int x) {
        return helper(x);
    }
}
