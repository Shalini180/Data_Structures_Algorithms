class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return - 1;
        if(target > nums[nums.length - 1]) return nums.length;

        int floor = -1;
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target) return mid;
            else if(target > nums[mid]){
                low = mid + 1;
            }
            else {
                high = mid - 1;
                floor = mid;
            }
        }

        return floor;
    }
}
