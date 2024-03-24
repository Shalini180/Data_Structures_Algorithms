class Solution {
    public int reqDays(int[] weights, int capacity){
        int currLoad = 0, day = 1;
        for(int i = 0;i<weights.length;i++){
            if(weights[i] <= capacity - currLoad){
                currLoad += weights[i];
            }
            else{
                day++;
                currLoad = weights[i];
            }
        }

        return day;
    }
    public int bsHelper(int[] weights, int days, int minCapacity, int maxCapacity){
        int answer = -1;
        while(minCapacity <= maxCapacity){ 
            int currCapacity = minCapacity + (maxCapacity - minCapacity)/2;
            int noOfDays = reqDays(weights, currCapacity);
            if(noOfDays > days){
                minCapacity = currCapacity + 1;
            }
            else{
                answer = currCapacity;
                maxCapacity = currCapacity - 1;
            }
        }

        return answer;
    }
    public int shipWithinDays(int[] weights, int days) {
        int maxCapacity = 0;
        int minCapacity = weights[0];
        for(int i = 0;i<weights.length;i++){
            maxCapacity += weights[i];
            minCapacity = Math.max(minCapacity, weights[i]);
        }
        
        return bsHelper(weights, days, minCapacity, maxCapacity);
    }
}
