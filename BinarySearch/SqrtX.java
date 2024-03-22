class Solution {
    public int mySqrt(int x) {
        if(x == 1) return 1;
        int left = 0, right = x/2;
        int ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if(mid * mid == x) return (int)mid;
            else if (mid * mid < x) {
                ans = (int)mid;
                left = (int)mid + 1;
            } else {
                right = (int)mid - 1;
            }
        }
        return ans;
    }
}
