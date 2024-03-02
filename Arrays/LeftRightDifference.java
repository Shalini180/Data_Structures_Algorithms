class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        leftSum[0] = 0;
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }

        int sum = leftSum[n - 1] + nums[n - 1];
        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(2 * leftSum[i] - sum + nums[i]);
        }

        return nums;
    }
}
