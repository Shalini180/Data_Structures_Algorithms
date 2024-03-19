class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int minDiff = nums[k - 1] - nums[0];
        for(int i = k;i<n;i++){
            int currDiff = nums[i] - nums[i - k + 1];
            minDiff = Math.min(minDiff, currDiff);
        }

        return minDiff;
    }
}
