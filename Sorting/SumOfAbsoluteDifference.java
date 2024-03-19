class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        for(int i = 0;i<n;i++){
            prefix[i] = (i == 0) ? nums[i] : nums[i] + prefix[i-1];
        }
        int[] ans = new int[n];
        for(int i = 0;i<n;i++){
            int left = i * nums[i];
            left -= (i == 0) ? 0 : prefix[i-1];
            int right = prefix[n-1] - prefix[i];
            right -= (n - 1 - i)*nums[i];
            ans[i] = left + right;
        }

        return ans;
    }
}
