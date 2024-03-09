class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] temp = Arrays.copyOf(nums, n);
        Arrays.sort(temp);
        int start = 0, end = n - 1;
        while (start < n && nums[start] == temp[start])
            start++;
        while (end > start && nums[end] == temp[end])
            end--;

        return end - start + 1;
    }
}
