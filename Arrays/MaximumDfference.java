class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int minElement = nums[0];
        int ans = -1;
        for(int j = 1;j<n;j++){
            if(minElement < nums[j])
                ans = Math.max(ans, nums[j] - minElement);
            else{
                minElement = Math.min(minElement, nums[j]);
            }
        }

        return ans;
    }
}
