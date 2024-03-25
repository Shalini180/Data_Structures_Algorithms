class Solution {
    public double noOfHours(int[] dist, int speed){
        double ans = 0;
        for(int i = 0;i<dist.length - 1;i++){
            ans += Math.ceil((double)dist[i]/speed);
        }

        ans += (double)dist[dist.length - 1]/speed;
        return ans;
    }
    public int bsHelper(int[] dist, double hour, int minSpeed, int maxSpeed){
        int ans = -1;
        while(minSpeed <= maxSpeed){
            int currSpeed = minSpeed + (maxSpeed - minSpeed)/2;
            double time = noOfHours(dist, currSpeed);
            if(time <= hour){
                ans = currSpeed;
                maxSpeed = currSpeed - 1;
            }
            else{
                minSpeed = currSpeed + 1;
            }
        }

        return ans;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int minSpeed = 1;
        int maxSpeed = 100000001;

        return bsHelper(dist, hour, minSpeed, maxSpeed);
    }
}
