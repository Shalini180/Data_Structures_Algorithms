class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double ans = Integer.MIN_VALUE;
        int i = 0, j = 0;
        int sum = 0;
        while(j < n){
            sum += nums[j];
            if((j - i + 1) == k){
                ans = Math.max(ans, (double)sum/(double)(k));
                sum -= nums[i];
                i++;
            }

            j++;
        }

        return ans;
    }
}
