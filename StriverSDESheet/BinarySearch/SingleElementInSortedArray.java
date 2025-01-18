class Solution {
    public boolean isLeftHalf(int[] nums, int ind){
        if(ind % 2 == 1){
            return (nums[ind] == nums[ind - 1]);
        }

        return nums[ind] == nums[ind + 1];
    }
    public int helper(int[] nums, int n){
        int low = 0;
        int high = n - 2;
        while(low <= high) {
            int mid = (low + high)/2;
            if(isLeftHalf(nums, mid) == true) low = mid + 1;
            else high = mid - 1;
        }

        return nums[low];
    }
    public int singleNonDuplicate(int[] nums) {
        return helper(nums, nums.length);
    }
}
