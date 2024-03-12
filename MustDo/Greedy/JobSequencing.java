class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));
        int maxi = 0;
        for(int i = 0;i<n;i++){
            maxi = Math.max(maxi, arr[i].deadline);
        }
        
        int[] schedule = new int[maxi + 1];
        Arrays.fill(schedule, -1);
        int count = 0, profit = 0;
        for(int i = 0;i<n;i++){
            for(int j = arr[i].deadline;j>0;j--){
                if(schedule[j] == -1){
                    schedule[j] = arr[i].id;
                    profit += arr[i].profit;
                    count+=1;
                    break;
                }
            }
        }
        
        int[] ans = new int[2];
        ans[0] = count;
        ans[1] = profit;
        return ans;
    }
}
