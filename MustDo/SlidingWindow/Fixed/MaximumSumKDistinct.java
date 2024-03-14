import java.util.Arrays;

class Solution {
    public long maximumSubarraySum(int[] nums, int windowSize) {
        int[] hashTable = new int[100001];
        Arrays.fill(hashTable, -1);
        int start = 0, end = 0;
        long currentSum = 0, maxSum = Long.MIN_VALUE;
        int length = nums.length;
        
        while (end < length) {
            if (hashTable[nums[end]] == -1) {
                currentSum += nums[end];
                hashTable[nums[end]] = 1;
            } else {
                currentSum -= nums[start];
                hashTable[nums[start]] = -1;
                start++;
                continue;
            }

            if (end - start + 1 < windowSize)
                end++;
            else if (end - start + 1 == windowSize) {
                maxSum = Math.max(maxSum, currentSum);
                currentSum -= nums[start];
                hashTable[nums[start]] = -1;
                start++;
                end++;
            }
        }

        if (maxSum == Long.MIN_VALUE)
            return 0;

        return maxSum;
    }
}
