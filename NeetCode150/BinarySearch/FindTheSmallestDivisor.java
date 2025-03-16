class Solution {
    public int helper(int[] nums, int k) {
        int ans = 0;
        for(int it : nums)ans += (int) Math.ceil((double) it / k); 
        return ans;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = nums[0];
        for(int i = 0; i < nums.length; i++) high = Math.max(high, nums[i]);
        while(low <= high){
            int mid = (low + high)/2;
            if(helper(nums, mid) > threshold) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }
}
