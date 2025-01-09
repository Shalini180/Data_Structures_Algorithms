class Solution {
    public int kandaneHelper(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length;i++){
            sum += nums[i];
            maxi = Math.max(sum, maxi);
            if(sum < 0) sum = 0;
        }

        return maxi;
    }
    public int maxSubArray(int[] nums) {
        return kandaneHelper(nums);
    }
}
