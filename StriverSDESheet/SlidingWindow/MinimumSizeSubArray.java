class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0, n = nums.length;
        int sub = 0, ans = Integer.MAX_VALUE;

        while (j < n) {
            sub += nums[j];

            while (i <= j && sub >= target) {
                ans = Math.min(ans, j - i + 1);
                sub -= nums[i];
                i++;
            }

            j++;
        }

        return (ans == Integer.MAX_VALUE) ? 0 : ans;
    }
}
