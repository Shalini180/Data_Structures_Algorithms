class Solution {
    public int minimumAverageDifference(int[] nums) {
        int length = nums.length;
        
        long[] prefixSum = new long[length];
        for (int i = 0; i < length; i++) {
            prefixSum[i] = (i == 0) ? nums[i] : prefixSum[i - 1] + nums[i];
        }
        
        long minDifference = Long.MAX_VALUE;
        int minIndex = -1;
        
        for (int i = 0; i < length; i++) {
            long numerator1 = prefixSum[i];
            long denominator1 = (i + 1);
            long numerator2 = prefixSum[length - 1] - prefixSum[i];
            long denominator2 = (length - (i + 1));
            
            long currentDifference = numerator1 / denominator1;
            if(i != length - 1)
                currentDifference = Math.abs(currentDifference - numerator2 / denominator2);
            
            if (currentDifference < minDifference) {
                minDifference = currentDifference;
                minIndex = i;
            }
        }

        return minIndex;
    }
}
