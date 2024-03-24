class Solution {
    public long requiredHours(int[] piles, long speed) {
        long hours = 0;
        for (int pile : piles) {
            hours += pile / speed;
            if ((pile % speed) != 0) 
                hours++;
        }
        return hours;
    }

    public long bsHelper(int[] piles, long h, long s, long e) {
        long ans = 0;
        while (s <= e) {
            long speed = s + (e - s) / 2;
            long reqHours = requiredHours(piles, speed);
            if (reqHours <= h) {
                ans = speed;
                e = speed - 1;
            } else {
                s = speed + 1;
            }
        }
        return ans;
    }

    public int minEatingSpeed(int[] piles, int h) {
        long minSpeed = 1;
        long maxSpeed = piles[0];
        int n = piles.length;
        for (int pile : piles) {
            maxSpeed = Math.max(maxSpeed, pile);
        }
        return (int) bsHelper(piles, h, minSpeed, maxSpeed);
    }
}
