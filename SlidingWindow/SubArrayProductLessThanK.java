class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        int product = 1, ans = 0;
        
        while (r < n) {
            product = product * nums[r];
            
            if (product >= k) {
                while (l < r && product >= k) {
                    product = product / nums[l];
                    l++;
                }
            }
            
            if (product < k)
                ans += (r - l + 1);
            r++;
        }

        return ans;
    }
}
