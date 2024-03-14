class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        long sum = 0, ans = Long.MIN_VALUE;
        int start = 0, end = 0;
        while(end < N){
            sum += Arr.get(end);
            
            if((end - start + 1) < K)
                end++;
            else if((end - start + 1) == K){
                ans = Math.max(ans, sum);
                sum -= Arr.get(start);
                start++;
                end++;
            }
        }
        
        return ans;
    }
}
