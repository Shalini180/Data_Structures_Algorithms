class Solution {
    public int helper(int[] piles, int k) {
        long hour = 0;
        for (int pile : piles) {
            hour += (pile + (long) k - 1) / k;
            if (hour > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        return (int) hour;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (helper(piles, mid) > h) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }

        return ans;
    }
}
