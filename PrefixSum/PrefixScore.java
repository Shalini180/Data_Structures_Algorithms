class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        int maxElement = nums[0];
        ans[0] = maxElement + nums[0];
        
        for (int i = 1; i < n; i++) {
            maxElement = Math.max(maxElement, nums[i]);
            ans[i] = maxElement + nums[i];
            ans[i] += ans[i - 1];
        }

        return ans;
    }
}
