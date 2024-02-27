class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        long maxSum = 0;long curSum = 0;
        int l = 0;
        int r = 0;
        while(r < N){
            if(r - l + 1 < K){
                curSum += Arr.get(r);
            }
            else if(r - l + 1 == K){
                curSum += Arr.get(r);
                maxSum = Math.max(maxSum, curSum);
                curSum -=Arr.get(l);
                l++;
            }
            
            r++;
        }
        
        return maxSum;
    }
}
