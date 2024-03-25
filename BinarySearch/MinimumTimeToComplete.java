class Solution {
    public long noOfTrips(int[] time, long t) {
        long ans = 0;
        for(int i = 0; i < time.length; i++){
            ans += t / time[i];
        }
        return ans;
    }
    
    public long bsHelper(int[] time, int target, long l, long r) {
        long ans = -1;
        while(l <= r){
            long currTime = l + (r - l) / 2; // Use long for currTime
            long noOfTrips = noOfTrips(time, currTime);
            if(noOfTrips >= target){
                ans = currTime;
                r = currTime - 1;
            } else {
                l = currTime + 1;
            }
        }
        return ans;
    }
    
    public long minimumTime(int[] time, int totalTrips) {
        long minTime = Integer.MAX_VALUE;
        long maxTime = 0;
        for(int i = 0; i < time.length; i++){
            minTime = Math.min(minTime, time[i]);
            maxTime = Math.max(maxTime, (long) time[i] * totalTrips);
        }

        return bsHelper(time, totalTrips, minTime, maxTime);
    }
}
