class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lSum = 0, rSum = 0;
        int i = 0, j = cardPoints.length - 1;
        while(i < k){
            lSum += cardPoints[i];
            i++;
        }

        int maxSum = lSum;
        while(i > 0){
            lSum -= cardPoints[i - 1];
            rSum += cardPoints[j];
            maxSum = Math.max(maxSum, lSum + rSum);
            i--;
            j--;
        }

        return maxSum;
    }
}
