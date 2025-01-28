class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0, j = n - 1;
        int k = n - 1;
        while(i <= j){
            int a = nums[i] * nums[i];
            int b = nums[j] * nums[j];
            if(a >= b){
                ans[k] = a;
                k--;
                i++;
            }
            else{
                ans[k] = b;
                j--;
                k--;
            }
        }

        return ans;
    }
}
