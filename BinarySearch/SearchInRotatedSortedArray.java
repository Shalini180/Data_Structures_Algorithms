class Solution {
    public int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else if (arr[mid] > target)
                right = mid - 1;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int rotationIndex = -1;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                rotationIndex = i;
                break;
            }
        }
        if (rotationIndex == -1)
            return binarySearch(nums, 0, n - 1, target);
        int left = binarySearch(nums, 0, rotationIndex - 1, target);
        int right = binarySearch(nums, rotationIndex, n - 1, target);
        return Math.max(left, right);
    }
}
