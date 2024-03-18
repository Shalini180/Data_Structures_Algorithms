class Solution
{
    static long merge(long[] arr, long left, long mid, long right){
        long ans = 0;
        long i = left, j = mid + 1;
        ArrayList<Long> temp = new ArrayList<>();
        while(i <= mid && j <= right){
            if(arr[(int)i] <= arr[(int)j]){
                temp.add(arr[(int)i]);
                i++;
            }else{
                ans += (mid + 1) - i;
                temp.add(arr[(int)j]);
                j++;
            }
        }
        while(i <= mid){
            temp.add(arr[(int)i]);
            i++;
        }
        while(j <= right){
            temp.add(arr[(int)j]);
            j++;
        }
        
        for(long k = left;k<=right;k++)
            arr[(int)k] = temp.get((int)(k - left));
        
        return ans;
    }
    static long inversionCountHelper(long[] arr, long left, long right){
        if(left >= right){
            return 0;
        }
        
        long mid = left + (right - left) / 2;
        return inversionCountHelper(arr, left, mid) + inversionCountHelper(arr, mid + 1, right) + merge(arr, left, mid, right);
    }
    static long inversionCount(long arr[], long N)
    {
        long ans = 0;
        ans = inversionCountHelper(arr, 0, N - 1);
        return ans;
    }
}
