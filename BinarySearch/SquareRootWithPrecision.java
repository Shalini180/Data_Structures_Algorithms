class Solution {
    public double helper(int x, int p){
        double precision = Math.pow(10, -p);
        double left = 0, right = x;
        double ans = 0;
        while(right - left >= precision){
            double midIndex = left + (right - left)/2;
            if(midIndex * midIndex == x)
                return midIndex;
            else if(midIndex * midIndex <= x){
                ans = midIndex;
                left = midIndex;
            }
            else{
                right = midIndex;
            }
        }

        return ans;
    }
    public int mySqrt(int x) {
        if(x == 1) return 1;
        int p = 1;
        double ans = helper(x, p);
        System.out.println(ans);
        return (int)ans;
    }
}
