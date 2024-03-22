class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = searchLeft(nums, target);
        int right = searchRight(nums, target);
        
        return new int[] {left, right};
    }
    
    private int searchLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                if (nums[mid] == target)
                    index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
    
    private int searchRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                if (nums[mid] == target)
                    index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
}
