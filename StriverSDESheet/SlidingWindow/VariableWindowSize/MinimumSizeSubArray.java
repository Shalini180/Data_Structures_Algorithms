class Solution {
    public double helper(int[] nums, int k){
        int sum = 0;
        double ans = (double)(Integer.MIN_VALUE);
        int i = 0, j = 0;
        while(j < nums.length){
            sum += nums[j];
            if((j - i + 1) == k){
                ans = Math.max(ans, sum/(double) k);
                sum -= nums[i];
                i++;
            }

            j++;
        }

        return ans;
    }
    public double findMaxAverage(int[] nums, int k) {
        return helper(nums, k);
    }
}
