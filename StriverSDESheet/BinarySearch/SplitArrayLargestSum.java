class Solution {
    public int helper(int[] nums, int value) {
        int count = 1, pageSize = 0;
        for(int i = 0; i < nums.length;i++){
            if(pageSize + nums[i] <= value) pageSize += nums[i];
            else{
                count++;
                pageSize = nums[i];
            }
        }

        return count;
    }
    public int splitArray(int[] nums, int k) {
        if(nums.length < k) return -1;
        int low = nums[0], high = nums[0];
        for(int i = 1; i < nums.length; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }

        while(low <= high){
            int mid = (low + high)/2;
            int currCount = helper(nums, mid);
            if(currCount > k) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }
}
