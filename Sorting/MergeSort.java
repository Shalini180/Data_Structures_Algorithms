import java.util.ArrayList;

class Solution {
    public void mergeSortedArrays(int[] nums, int left, int mid, int right) {
        ArrayList<Integer> mergedArray = new ArrayList<>();
        int leftIndex = left, rightIndex = mid + 1;

        while (leftIndex <= mid && rightIndex <= right) {
            if (nums[leftIndex] <= nums[rightIndex]) {
                mergedArray.add(nums[leftIndex]);
                leftIndex++;
            } else {
                mergedArray.add(nums[rightIndex]);
                rightIndex++;
            }
        }

        while (leftIndex <= mid) {
            mergedArray.add(nums[leftIndex]);
            leftIndex++;
        }

        while (rightIndex <= right) {
            mergedArray.add(nums[rightIndex]);
            rightIndex++;
        }

        for (int i = left; i <= right; i++)
            nums[i] = mergedArray.get(i - left);
    }

    public void sortHelper(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        sortHelper(nums, left, mid);
        sortHelper(nums, mid + 1, right);
        mergeSortedArrays(nums, left, mid, right);
    }

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        sortHelper(nums, 0, n - 1);
        return nums;
    }
}
