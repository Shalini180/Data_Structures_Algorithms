class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = 1_000_000_007;
        int n = nums.length;
        
        // Sort the array for two-pointer technique
        Arrays.sort(nums);
        
        // Precompute powers of 2 up to n-1, modulo mod
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = (prefix[i - 1] * 2) % mod;
        }

        int start = 0, end = n - 1;
        int ans = 0;

        // Two-pointer approach to count valid subsequences
        while (start <= end) {
            int sum = nums[start] + nums[end];
            
            if (sum <= target) {
                // Calculate the number of subsequences with nums[start] as min and nums[end] as max
                int subsets = prefix[end - start];
                ans = (ans + subsets) % mod;
                start++;
            } else {
                end--;
            }
        }

        return ans;
    }
}
